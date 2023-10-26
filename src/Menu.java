import java.util.Scanner;

public class Menu {

    private final String quitString = "q";
    

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

        Scanner sc = new Scanner(System.in);




    }

    private void mainMenu() {
        System.out.println("--- Calculadora de IMC ---");
        System.out.println("Por favor insira a altura e o peso para calcular: ");
    }

    private int perguntarPeso(Pessoa p) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o Peso: ");
        String entrada = sc.nextLine();
        if (entrada.isEmpty()) {
            return -1;
        }
        double peso = Double.parseDouble(entrada);
        if (entrada.toLowerCase().contains("lb")) {
            p.setPesoPound(peso);
        }
        else {
            p.setPeso(peso);
        }
        return 0;
    }
}
