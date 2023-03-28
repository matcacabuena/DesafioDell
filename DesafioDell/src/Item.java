public enum Item {
    CELULAR("celular", 0.5), GELADEIRA("geladeira", 60), FREEZER("freezer", 100), 
    CADEIRA("cadeira", 5), LUMINARIA("luminaria", 0.8), LAVADORA("lavadora de roupa", 120);

    private final String nome;

    private final double peso;

    Item(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
    
}