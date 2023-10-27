package Conversao;

public class Conversor {

    public static double FtParaM(double feet) {
        return feet*0.3048;
    }

    public static double InParaM(double inch) {
        return inch*0.0254;
    }

    public static double PoundParaKg(double pound) {
        return pound*0.45359237;
    }

    public static double CmParaM(double cm) {
        return cm/100.0;
    }
}
