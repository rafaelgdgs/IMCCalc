import Conversao.Conversor;

public class Pessoa {

    private double altura;
    private double peso;
    private static Pessoa instance;

    public static Pessoa get() {
        if (Pessoa.instance == null) {
            Pessoa.instance = new Pessoa();
        }
        return Pessoa.instance;
    }

    private Pessoa() {
        altura = 0.0;
        peso = 0.0;
    }

    public double CalcularIMC() {
        return peso/(altura * altura);
    }

    public void setAltura(double _altura) {
        altura = _altura;
    }

    public void setAlturaFt(double _ft, double _inch) {
        altura = Conversor.FtParaM(_ft) + Conversor.InParaM(_inch);
    }

    public void setAlturaCm(double _altura) {
        altura = Conversor.CmParaM(_altura);
    }

    public void setPeso(double _peso) {
        peso = _peso;
    }

    public void setPesoPound(double _lb) {
        peso = Conversor.PoundParaKg(_lb);
    }
}
