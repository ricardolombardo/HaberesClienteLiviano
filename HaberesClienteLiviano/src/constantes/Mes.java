package constantes;

public enum Mes {
    ENERO(1),
    FEBRERO(2),
    MARZO(3),
    ABRIL(4),
    MAYO(5),
    JUNIO(6),
    JULIO(7),
    AGOSTO(8),
    SEPTIEMBRE(9),
    OCTUBRE(10),
    NOVIEMBRE(11),
    DICIEMBRE(12);

    private final int numero;

    Mes(int numero) { 
        this.numero = numero; 
    }

    public int getNumero() { 
        return numero; 
    }

    // Opcional: buscar por número
    public static Mes desdeNumero(int n) {
        for (Mes m : values()) {
            if (m.numero == n) return m;
        }
        throw new IllegalArgumentException("Número de mes inválido: " + n);
    }
}
