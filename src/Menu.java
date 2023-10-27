import java.util.Scanner;

public class Menu {

    private final String quitString = "q";
    private final int success = 1;
    private final int inputError = 2;
    private final int quitSignal = 3;
    private static Menu instance;
    private Pessoa pessoa;

    public static Menu get() {
        if (Menu.instance == null) {
            Menu.instance = new Menu();
        }
        return Menu.instance;
    }

    public Menu() {

    }

    private void init() {
        pessoa = Pessoa.get();
    }

    public void run() {
        init();
        programLoop();
        exitScreen();
    }

    private void programLoop() {
        while (true) {
            mainMenu();
            int perguntaPesoSignal;
            perguntaPesoSignal = perguntarPeso(pessoa);
            while (perguntaPesoSignal != success) {
                if (perguntaPesoSignal == quitSignal) {
                    return;
                }
                entradaErrada();
                perguntaPesoSignal = perguntarPeso(pessoa);
            }
            int perguntaAlturaSignal = perguntarAltura(pessoa);
            while (perguntaAlturaSignal != success) {
                if (perguntaAlturaSignal == quitSignal) {
                    return;
                }
                entradaErrada();
                perguntaAlturaSignal = perguntarAltura(pessoa);
            }
            printIMC(pessoa);
            System.out.println();
        }
    }

    private void mainMenu() {
        System.out.println("--- Calculadora de IMC ---");
        System.out.println("Por favor insira a altura e o peso para calcular.");
    }

    private int perguntarPeso(Pessoa p) {
        Scanner sc = new Scanner(System.in);
        System.out.print(entradaPronta("Insira o Peso"));
        String entrada = sc.nextLine();
        if (checaEntrada(entrada) == quitSignal) {
            return quitSignal;
        }
        if (entrada.isEmpty()) {
            return inputError;
        }
        double peso = Double.parseDouble(entrada);
        if (entrada.toLowerCase().contains("lb")) {
            p.setPesoPound(peso);
        }
        else {
            p.setPeso(peso);
        }
        return success;
    }

    private int perguntarAltura(Pessoa p) {
        Scanner sc = new Scanner(System.in);
        System.out.print(entradaPronta("Insira a Altura"));
        String entrada = sc.nextLine();
        if (checaEntrada(entrada) == quitSignal) {
            return quitSignal;
        }
        if (entrada.isEmpty()) {
            return inputError;
        }
        double altura = Double.parseDouble(entrada);
        double inch = 0.0;
        if (entrada.toLowerCase().contains("ft")) {
            p.setAlturaFt(altura, inch);
        }
        else {
            p.setAltura(altura);
        }
        return success;
    }

    private void entradaErrada() {
        System.out.println("Entrada inserida invalida, tente novamente.");
    }

    private void exitScreen() {
        System.out.println("Bye Bye -__-");
    }

    private String opcoesEntrada() {
        return String.format("(Insira %s para sair)", quitString);
    }

    private String entradaPronta(String texto) {
        return texto + " " + opcoesEntrada() + ": ";
    }

    public void printIMC(Pessoa p) {
        System.out.println("O seu IMC é igual a: " + String.format("%.2f", p.CalcularIMC()));
    }

    private int checaEntrada(String entrada) {
        if (entrada.equals(quitString)) {
            return quitSignal;
        }
        else {
            return success;
        }
    }
}
