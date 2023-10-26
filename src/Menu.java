public class Menu {

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




    }

    private void mainMenu() {
        System.out.println("--- Calculadora de IMC ---");
    }
}
