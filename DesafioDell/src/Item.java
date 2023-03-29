public enum Item {
    CELULAR("celular", 0.5), GELADEIRA("geladeira", 60), FREEZER("freezer", 100), 
    CADEIRA("cadeira", 5), LUMINARIA("luminaria", 0.8), LAVADORA("lavadora de roupa", 120);

    private final String nome;

    private final double peso;

    private int quantidade;

    Item(String nome, double peso ) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantity() {
        return quantidade;
    }

    public void setQuantity(int itemQuantity) {
        this.quantidade = itemQuantity;
    }

    public int removeQuantity(int removedItems) {
        if(this.quantidade > 0) {
            this.quantidade = this.quantidade - removedItems;
            return removedItems;
        } else {
            return 0;
        }

    }

    public double getPeso() {
        return peso;
    }
    
}