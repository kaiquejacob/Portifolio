print("-----------------------------")
print("Universidade Paulista - UNIP")
print("-----------------------------")


# Função para calcular média ponderada
def calcular_media(np1, np2, pim):
    return (np1 * 4 + np2 * 4 + pim * 2) / 10


# Função para cadastrar aluno
def cadastrar_aluno():
    aluno = {}
    aluno["nome"] = input("Nome do aluno: ")
    aluno["ra"] = input("RA: ")
    aluno["curso"] = input("Curso: ")
    aluno["semestre"] = input("Semestre: ")
    aluno["materias"] = []
    return aluno


# Função para buscar aluno pelo RA
def buscar_aluno(ra, alunos):
    for aluno in alunos:
        if aluno["ra"] == ra:
            return aluno
    return None


# Função para cadastrar matérias e notas
def cadastrar_materias(aluno):
    while True:
        print(f"\nCadastrando matéria para {aluno['nome']}")
        materia = input("Nome da matéria: ")

        np1 = float(input("Nota NP1: "))
        np2 = float(input("Nota NP2: "))
        pim = float(input("Nota PIM: "))

        media = calcular_media(np1, np2, pim)

        dados_materia = {
            "materia": materia,
            "media": media
        }

        # Regra de aprovação
        if media >= 7:
            dados_materia["status"] = "Aprovado direto ✅"
        else:
            print("Exame necessário! ⚠️")
            exame = float(input("Nota do exame: "))
            media_final = (media + exame) / 2

            dados_materia["media_final"] = media_final

            if media_final >= 5:
                dados_materia["status"] = "Aprovado no exame ✅"
            else:
                dados_materia["status"] = "Reprovado ❌"

        aluno["materias"].append(dados_materia)

        continuar = input("Deseja cadastrar outra matéria? (s/n): ")
        if continuar.lower() != "s":
            break


# Função para mostrar alunos
def mostrar_alunos(alunos):
    if len(alunos) == 0:
        print("Nenhum aluno cadastrado.")
        return

    for aluno in alunos:
        print("\n===== DADOS DO ALUNO =====")
        print(f"Nome: {aluno['nome']}")
        print(f"RA: {aluno['ra']}")
        print(f"Curso: {aluno['curso'].upper()}")
        print(f"Semestre: {aluno['semestre']}º ")

        print("\n--- Matérias ---")
        for m in aluno["materias"]:
            print(f"\nMatéria: {m['materia'].upper()}")
            print(f"Média: {m['media']:.2f}")

            if "media_final" in m:
                print(f"Média final: {m['media_final']:.2f}")

            print(f"Status: {m['status']}")
            print("\n-------------------------------")

# Programa principal
alunos = []

while True:
    print("\n1 - Cadastrar aluno")
    print("2 - Cadastrar matéria/notas")
    print("3 - Mostrar alunos")
    print("0 - Sair")

    opcao = input("Escolha: ")

    if opcao == "1":
        aluno = cadastrar_aluno()
        alunos.append(aluno)

    elif opcao == "2":
        ra = input("Digite o RA do aluno: ")
        aluno = buscar_aluno(ra, alunos)

        if aluno:
            cadastrar_materias(aluno)
        else:
            print("Aluno não encontrado!")

    elif opcao == "3":
        mostrar_alunos(alunos)

    elif opcao == "0":
        print("Programa encerrado.")
        break

    else:
        print("Opção inválida!")