
import sqlite3
from statistics import multimode

print("=" * 40)
print(f"{'UNIVERSIDADE PAULISTA':^40}")
print(f"{'- UNIP -':^40}")
print("=" * 40)

# Conexão com banco de dados
conexao = sqlite3.connect("unip_alunos.db")
cursor = conexao.cursor()

# Cria tabelas se não existirem
cursor.execute("""
    CREATE TABLE IF NOT EXISTS ALUNOS (
        ID INTEGER PRIMARY KEY AUTOINCREMENT,
        NOME VARCHAR NOT NULL,
        RA VARCHAR NOT NULL,
        CURSO VARCHAR NOT NULL,
        SEMESTRE INTEGER NOT NULL
    )
""")
cursor.execute("""
    CREATE TABLE IF NOT EXISTS MATERIAS (
        ID INTEGER PRIMARY KEY AUTOINCREMENT,
        RA VARCHAR NOT NULL,
        MATERIA VARCHAR NOT NULL,
        MEDIA FLOAT NOT NULL,
        MEDIA_FINAL FLOAT,
        STATUS VARCHAR NOT NULL
    )
""")
conexao.commit()

CURSOS = [
    'Análise e Desenvolvimento de Sistemas',
    'Ciência da Computação',
    'Redes de Computadores',
    'Defesa Cibernética',
    'Gestão de TI'
]


def calcular_media(np1, np2, pim):
    return (np1 * 4 + np2 * 4 + pim * 2) / 10


def escolher_curso():
    print("\n" + "=" * 40)
    print(f"{'CURSOS DISPONÍVEIS':^40}")
    print("=" * 40)
    for i, curso in enumerate(CURSOS):
        print(f"  [{i}] {curso}")
    while True:
        try:
            escolha = int(input("Número do curso: "))
            if 0 <= escolha <= len(CURSOS) - 1:
                return CURSOS[escolha]
            print(f"Digite um número entre 0 e {len(CURSOS) - 1}.")
        except ValueError:
            print("Entrada inválida.")


def cadastrar_aluno():
    nome = input("Nome do aluno: ")
    ra = input("RA: ")

    # Verifica se RA já existe
    if cursor.execute("SELECT 1 FROM ALUNOS WHERE RA = ?", (ra,)).fetchone():
        print("Já existe um aluno com esse RA!")
        return

    curso = escolher_curso()
    semestre = input("Semestre: ")

    cursor.execute(
        "INSERT INTO ALUNOS (NOME, RA, CURSO, SEMESTRE) VALUES (?, ?, ?, ?)",
        (nome, ra, curso, semestre)
    )
    conexao.commit()
    print("=" * 40)
    print(f"Aluno {nome} cadastrado com sucesso!")
    print("=" * 40)


def buscar_aluno(ra):
    return cursor.execute("SELECT * FROM ALUNOS WHERE RA = ?", (ra,)).fetchone()


def cadastrar_materias(ra):
    aluno = buscar_aluno(ra)
    if not aluno:
        print("Aluno não encontrado!")
        return

    while True:
        print(f"\n" + "-" * 40)
        print(f"  Cadastrando matéria para {aluno[1]}")
        print("-" * 40)
        materia = input("Nome da matéria: ")

        np1 = float(input("Nota NP1: "))
        np2 = float(input("Nota NP2: "))
        pim = float(input("Nota PIM: "))
        media = calcular_media(np1, np2, pim)

        media_final = None
        if media >= 7:
            status = "Aprovado direto ✅"
        else:
            print("Exame necessário! ⚠️")
            exame = float(input("Nota do exame: "))
            media_final = (media + exame) / 2
            status = "Aprovado no exame ✅" if media_final >= 5 else "Reprovado ❌"

        cursor.execute(
            "INSERT INTO MATERIAS (RA, MATERIA, MEDIA, MEDIA_FINAL, STATUS) VALUES (?, ?, ?, ?, ?)",
            (ra, materia, media, media_final, status)
        )
        conexao.commit()
        print("-" * 40)
        print(f"  Matéria cadastrada! Status: {status}")
        print("-" * 40)

        if input("Cadastrar outra matéria? (s/n): ").lower() != "s":
            break


def mostrar_alunos():
    alunos = cursor.execute("SELECT * FROM ALUNOS").fetchall()
    if not alunos:
        print("Nenhum aluno cadastrado.")
        return

    for aluno in alunos:
        id_, nome, ra, curso, semestre = aluno
        print("\n" + "=" * 40)
        print(f"{'DADOS DO ALUNO':^40}")
        print("=" * 40)
        print(f"  Nome:     {nome}")
        print(f"  RA:       {ra}")
        print(f"  Curso:    {curso.upper()}")
        print(f"  Semestre: {semestre}º")

        materias = cursor.execute("SELECT * FROM MATERIAS WHERE RA = ?", (ra,)).fetchall()
        if materias:
            print("\n" + "-" * 40)
            print(f"{'MATÉRIAS':^40}")
            print("-" * 40)
            for m in materias:
                _, _, materia, media, media_final, status = m
                print(f"\n  Matéria: {materia.upper()}")
                print(f"  Média:   {media:.2f}")
                if media_final is not None:
                    print(f"  Média final: {media_final:.2f}")
                print(f"  Status:  {status}")
                print("  " + "- " * 19)
        else:
            print("  Nenhuma matéria cadastrada.")


def remover_aluno():
    alunos = cursor.execute("SELECT ID, NOME, RA FROM ALUNOS").fetchall()
    if not alunos:
        print("Nenhum aluno cadastrado.")
        return

    print("\n" + "=" * 40)
    print(f"{'REMOVER ALUNO':^40}")
    print("=" * 40)
    for a in alunos:
        print(f"  ID: {a[0]} | Nome: {a[1]} | RA: {a[2]}")
    print("-" * 40)

    ra = input("\nDigite o RA do aluno a remover: ")
    aluno = buscar_aluno(ra)
    if not aluno:
        print("Aluno não encontrado!")
        return

    confirma = input(f"Confirmar remoção de {aluno[1]}? (s/n): ")
    if confirma.lower() == "s":
        cursor.execute("DELETE FROM ALUNOS WHERE RA = ?", (ra,))
        cursor.execute("DELETE FROM MATERIAS WHERE RA = ?", (ra,))
        conexao.commit()
        print("=" * 40)
        print("  Aluno removido com sucesso!")
        print("=" * 40)


def estatisticas():
    medias = [row[0] for row in cursor.execute("SELECT MEDIA FROM MATERIAS").fetchall()]
    if not medias:
        print("Nenhuma nota cadastrada.")
        return

    # Mediana
    ordenadas = sorted(medias)
    n = len(ordenadas)
    meio = n // 2
    mediana = ordenadas[meio] if n % 2 == 1 else (ordenadas[meio - 1] + ordenadas[meio]) / 2

    # Moda
    modas = multimode(medias)
    if len(modas) == len(set(medias)):
        moda_str = "Amodal (nenhuma nota se repete)"
    else:
        moda_str = ", ".join(f"{m:.2f}" for m in modas)

    print("\n" + "=" * 40)
    print(f"{'ESTATÍSTICAS DAS MÉDIAS':^40}")
    print("=" * 40)
    print(f"  Total de notas:  {n}")
    print(f"  Mediana:         {mediana:.2f}")
    print(f"  Moda:            {moda_str}")
    print("=" * 40)


# Programa principal
while True:
    print(" \nMENU PRINCIPAL\n")
    print("  1 - Cadastrar aluno")
    print("  2 - Cadastrar matéria/notas")
    print("  3 - Mostrar alunos")
    print("  4 - Remover aluno")
    print("  5 - Estatísticas (moda e mediana)")
    print("  0 - Sair")
    print("=" * 40)

    opcao = input("Escolha: ")

    match opcao:
        case "1":
            cadastrar_aluno()
        case "2":
            ...
        case "3":
            mostrar_alunos()
        case "4":
            remover_aluno()
        case "5":
            estatisticas()
        case "0":
            print("Programa encerrado...")
            conexao.close()
            break
        case _:
            print("Opção inválida!")