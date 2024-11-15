package br.fsa;

import br.fsa.pessoa.Aluno;
import br.fsa.pessoa.Professor;
import br.fsa.faculdade.Curso;
import br.fsa.faculdade.Materia;
import br.fsa.faculdade.Nota;
import br.fsa.util.Log;
import br.fsa.util.ErroCadastro;
import br.fsa.util.Utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GerenciaFaculdade {
    private static final List<Aluno> alunos = new ArrayList<>();
    private static final List<Professor> professores = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Materia> materias = new ArrayList<>();
    private static final List<Nota> notas = new ArrayList<>();
    private static final Log log = new Log("ArquivoLog.txt");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nGerenciaFaculdade");
            System.out.println("1-Alunos");
            System.out.println("2-Professores");
            System.out.println("3-Cursos");
            System.out.println("4-Materias");
            System.out.println("5-Notas");
            System.out.println("0-Sair");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuProfessor();
                    break;
                case 3:
                    menuCurso();
                    break;
                case 4:
                    menuMateria();
                    break;
                case 5:
                    menuNota();
                    break;
                case 0:
                    System.out.println("Saindo");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuMateria() {
        while (true) {
            System.out.println("\nMatérias");
            System.out.println("1-Adicionar Matéria");
            System.out.println("2-Listar Matérias");
            System.out.println("3-Voltar");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    addMateria();
                    break;
                case 2:
                    listarMaterias();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addMateria() {
        System.out.print("Digite o nome da matéria: ");
        String nomeMateria = scanner.nextLine();

        boolean materiaExiste = materias.stream()
                .anyMatch(m -> m.getNome().equalsIgnoreCase(nomeMateria));

        if (materiaExiste) {
            System.out.println("Essa matéria já está cadastrada!");
            return;
        }

        Materia novaMateria = new Materia(nomeMateria);
        materias.add(novaMateria);

        log.logInfo("Nova matéria: " + nomeMateria);
        System.out.println("Matéria adicionada!");
    }

    private static void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("Nenhuma matéria cadastrada.");
            return;
        }

        System.out.println("\nLista de Matérias");
        materias.forEach(materia ->
                System.out.printf("Código: %d | Nome: %s\n",
                        materia.getCodigoUnico(), materia.getNome())
        );
    }

    private static void menuAluno() {
        while (true) {
            System.out.println("\nAlunos");
            System.out.println("1-Adicionar Aluno");
            System.out.println("2-Listar Alunos");
            System.out.println("3-Editar Aluno");
            System.out.println("4-Remover Aluno");
            System.out.println("5-Voltar");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    editarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void validarCodigoAluno(String codAluno) throws ErroCadastro {
        if (codAluno == null || codAluno.trim().isEmpty()) {
            throw new ErroCadastro("Código não pode ser vazio.");
        }

        if (!codAluno.matches("\\d{6}")) {
            throw new ErroCadastro("Código deve conter 6 dígitos.");
        }

        boolean codigoExistente = alunos.stream()
                .anyMatch(aluno -> String.valueOf(aluno.getCodUnico()).equals(codAluno));

        if (codigoExistente) {
            throw new ErroCadastro("Código já cadastrado.");
        }
    }

    private static void adicionarAluno() {
        try {
            System.out.println("\nAdicionar aluno");
            String codAluno;
            while (true) {
                System.out.print("Código (6 dígitos): ");
                codAluno = scanner.nextLine();

                try {
                    validarCodigoAluno(codAluno);
                    break;
                } catch (ErroCadastro e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            validarNome(nome);

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNasc = parseData(scanner.nextLine());

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            validarCPF(cpf);

            System.out.print("RG: ");
            String rg = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("CEP: ");
            String cep = scanner.nextLine();

            System.out.print("Rua: ");
            String rua = scanner.nextLine();

            System.out.print("Número: ");
            String numero = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            validarTel(telefone);

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            int codUnico = alunos.size() + 1;
            Aluno novoAluno = new Aluno(
                    nome, dataNasc, endereco, cep, rua, numero,
                    cidade, estado, telefone, genero, rg, cpf, curso, codUnico
            );
            alunos.add(novoAluno);
            log.logInfo("Aluno adicionado: " + nome);
            System.out.println("Aluno cadastrado!");

        } catch (ErroCadastro e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nLista de Alunos");
        alunos.forEach(aluno ->
                System.out.printf("Código: %d | Nome: %s | Curso: %s\n",
                        aluno.getCodUnico(), aluno.getNome(), aluno.getCurso())
        );
    }

    private static void editarAluno() {
        System.out.print("Digite o código do aluno a editar: ");
        int codigo = lerInt();
        Aluno aluno = alunos.stream()
                .filter(a -> a.getCodUnico() == codigo)
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Editar dados de: " + aluno.getNome());
    }

    private static void removerAluno() {
        System.out.print("Digite o código do aluno a remover: ");
        int codigo = lerInt();

        boolean removido = alunos.removeIf(a -> a.getCodUnico() == codigo);

        if (removido) {
            System.out.println("Aluno removido!");
        } else {
            System.out.println("Aluno não foi encontrado.");
        }
    }

    private static void validarNome(String nome) throws ErroCadastro {
        if (!nome.matches("[a-zA-ZÀ-ú\\s]+")) {
            throw new ErroCadastro("Nome inválido.");
        }
    }
    // Validação do CPF
    private static void validarCPF(String cpf) throws ErroCadastro {
        if (!Utilitarios.verificaCPF(cpf)) {
            throw new ErroCadastro("CPF inválido.");
        }
    }
    //Validação do Telefone  do aluno
    private static void validarTel(String tel) throws ErroCadastro {
        if (!Utilitarios.verificaTel(tel)) {
            throw new ErroCadastro("Telefone inválido.");
        }
    }

    private static Date parseData(String dataStr) throws ErroCadastro {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
        } catch (ParseException e) {
            throw new ErroCadastro("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }

    private static void menuProfessor() {
        while (true) {
            System.out.println("\nProfessores");
            System.out.println("1-Adicionar Professor");
            System.out.println("2-Listar Professores");
            System.out.println("3-Editar Professor");
            System.out.println("4-Remover Professor");
            System.out.println("5-Voltar");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    adicionarProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    editarProfessor();
                    break;
                case 4:
                    removerProfessor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarProfessor() {
        try {
            System.out.println("\nAdicionar Professor");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            validarNome(nome);

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNascimento = parseData(scanner.nextLine());

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("CEP: ");
            String cep = scanner.nextLine();

            System.out.print("Rua: ");
            String rua = scanner.nextLine();

            System.out.print("Número: ");
            String numero = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("Telefone: ");
            String tel = scanner.nextLine();
            validarTel(tel);

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("RG: ");
            String rg = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            validarCPF(cpf);

            System.out.print("Matérias: ");
            String[] materiasArray = scanner.nextLine().split(",");
            List<String> materias = Arrays.asList(materiasArray);

            System.out.print("Código Único: ");
            int codUnico = Integer.parseInt(scanner.nextLine());

            Professor professor = new Professor(nome, dataNascimento, endereco, cep, rua, numero, cidade, estado, tel, genero, rg, cpf, materias, codUnico);
            professores.add(professor);
            log.logInfo("Professor adicionado: " + nome);
            System.out.println("Professor adicionado: " + professor);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar professor: " + e.getMessage());
        }
    }

    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.println("\nLista de professores");
        professores.forEach(professor ->
                System.out.printf("Código: %d | Nome: %s\n",
                        professor.getCodUnico(), professor.getNome())
        );
    }

    private static void editarProfessor() {
        System.out.print("Digite o código do professor a editar: ");
        int codigo = lerInt();

        Professor professor = professores.stream()
                .filter(p -> p.getCodUnico() == codigo)
                .findFirst()
                .orElse(null);

        if (professor == null) {
            System.out.println("Professor não foi encontrado.");
            return;
        }

        System.out.println("Editar dados de: " + professor.getNome());
    }

    private static void removerProfessor() {
        System.out.print("Digite o código do professor: ");
        int codigo = lerInt();

        boolean removido = professores.removeIf(p -> p.getCodUnico() == codigo);

        if (removido) {
            System.out.println("Professor removido!");
        } else {
            System.out.println("Professor não foi encontrado.");
        }
    }

    private static void menuCurso() {
        while (true) {
            System.out.println("\nCursos");
            System.out.println("1-Adicionar Curso");
            System.out.println("2-Listar Cursos");
            System.out.println("3-Voltar");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    adicionarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarCurso() {
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.nextLine();
        Curso novoCurso = new Curso(nomeCurso);
        cursos.add(novoCurso);
        log.logInfo("Curso adicionado: " + nomeCurso);
        System.out.println("Curso adicionado!");
    }

    private static void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.println("\nLista Cursos");
        cursos.forEach(curso ->
                System.out.printf("Código: %d | Nome: %s\n",
                        curso.getCodigoUnico(), curso.getNome())
        );
    }

    private static void menuNota() {
        while (true) {
            System.out.println("\nNotas");
            System.out.println("1-Adicionar Nota");
            System.out.println("2-Calcular Média");
            System.out.println("3-Listar Notas");
            System.out.println("4-Voltar");
            System.out.print("Selecione uma opção: ");

            int opcao = lerInt();
            switch (opcao) {
                case 1:
                    adicionarNota();
                    break;
                case 2:
                    calcMedia();
                    break;
                case 3:
                    listarNotas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarNota() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno está cadastrado.");
            return;
        }

        if (materias.isEmpty()) {
            System.out.println("Nenhuma matéria está cadastrada.");
            return;
        }

        Aluno aluno = selecionarAluno();
        if (aluno == null) return;

        Materia materia = selecionarMateria();
        if (materia == null) return;

        try {
            System.out.print("P1: ");
            double p1 = lerDouble();

            System.out.print("P2: ");
            double p2 = lerDouble();

            System.out.print("Trabalho: ");
            double trabalho = lerDouble();

            Nota novaNota = new Nota(aluno, materia, p1, p2, trabalho);
            notas.add(novaNota);

            log.logInfo("Nota adicionada para o aluno: " + aluno.getNome() +
                    " na matéria: " + materia.getNome());
            System.out.println("Nota adicionada!");

        } catch (Exception e) {
            System.out.println("Erro ao adicionar nota: " + e.getMessage());
        }
    }

    private static Aluno selecionarAluno() {
        System.out.println("Alunos disponíveis:");
        alunos.forEach(a ->
                System.out.printf("Código: %d | Nome: %s\n", a.getCodUnico(), a.getNome())
        );

        System.out.print("Digite o código: ");
        int codigoAluno = lerInt();

        Aluno aluno = alunos.stream()
                .filter(a -> a.getCodUnico() == codigoAluno)
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não foi encontrado.");
        }

        return aluno;
    }

    private static Materia selecionarMateria() {
        System.out.println("Matérias disponíveis:");
        materias.forEach(m ->
                System.out.printf("Código: %d | Nome: %s\n", m.getCodigoUnico(), m.getNome())
        );

        System.out.print("Digite o nome da matéria: ");
        String nomeMateria = scanner.nextLine();

        Materia materia = materias.stream()
                .filter(m -> m.getNome().equalsIgnoreCase(nomeMateria))
                .findFirst()
                .orElse(null);

        if (materia == null) {
            System.out.println("Matéria não foi encontrada.");
        }

        return materia;
    }

    private static void calcMedia() {
        Aluno aluno = selecionarAluno();
        if (aluno == null) return;

        Materia materia = selecionarMateria();
        if (materia == null) return;

        List<Nota> notasAluno = notas.stream()
                .filter(n -> n.getAluno().getCodUnico() == aluno.getCodUnico()
                        && n.getMateria().getNome().equalsIgnoreCase(materia.getNome()))
                .collect(Collectors.toList());

        if (notasAluno.isEmpty()) {
            System.out.println("Nenhuma nota encontrada.");
            return;
        }

        List<Double> notasAtividade = new ArrayList<>();

        System.out.print("\nDigite a quantidade de atividades: ");
        int quantidadeAtividade = lerInt();

        for (int i = 0; i < quantidadeAtividade; i++) {
            System.out.print("Digite a nota da atividade " + (i + 1) + ": ");
            double nota = lerDouble();
            notasAtividade.add(nota);
        }

        double somaNotasAtividade = notasAtividade.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double notaFinalAtividade = (somaNotasAtividade / quantidadeAtividade) * 0.2;

        double mediaProvas = notasAluno.stream()
                .mapToDouble(n -> ((n.getP1() + n.getP2()) / 2) * 0.8)
                .findFirst()
                .orElse(0);

        double mediaGeral = mediaProvas + notaFinalAtividade;

        String status;
        if (mediaGeral >= 5) {
            status = "APROVADO";
            System.out.printf("\nA sua média geral foi: %.2f\n", mediaGeral);
            System.out.println("\nVocê passou!");
        } else if (mediaGeral >= 3) {
            status = "Recuperação";
            System.out.printf("\nA sua nota foi: %.2f\n", mediaGeral);
            System.out.println("\nVocê reprovou e terá que fazer P3");

            System.out.print("\nDigite a nota da P3: ");
            double notaP3 = lerDouble(); // Use lerDouble()

            double mediaFinal = (mediaGeral + notaP3) / 2;

            if (mediaFinal >= 5) {
                status = "APROVADO";
                System.out.printf("\nA sua nota final foi: %.2f\n", mediaFinal);
                System.out.println("\nVocê passou!");
            } else {
                status = "REPROVADO";
                System.out.printf("\nA sua nota final foi: %.2f\n", mediaFinal);
                System.out.println("\nVocê reprovou!");
            }
        } else {
            status = "REPROVADO";
            System.out.println("Você reprovou!");
        }

        // Log da operação
        log.logInfo("Média calculada para aluno: " + aluno.getNome() +
                " na matéria: " + materia.getNome() +
                " - Média: " + mediaGeral + " - Status: " + status);
    }

    private static void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota foi cadastrada.");
            return;
        }

        System.out.println("\nNotas");
        notas.forEach(nota ->
                System.out.printf("Aluno: %s | Matéria: %s | P1: %.2f | P2: %.2f | Trabalho: %.2f\n",
                        nota.getAluno().getNome(),
                        nota.getMateria().getNome(),
                        nota.getP1(),
                        nota.getP2(),
                        nota.getTrabalho())
        );
    }

    private static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número válido: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número válido: ");
            }
        }
    }
}