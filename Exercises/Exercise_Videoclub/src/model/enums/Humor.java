package model.enums;

public enum Humor {

    Absurdo("Absurdo","También conocido como “humor deadpan”, el humor seco es una expresión"),
    Seco("Seco","el humor seco es una expresión humorística en la que la persona muestra serenidad y una actitud impasible"),
    Satira("Satira","El humor satírico se basa en el discurso para generar cierta gracia en el público oyente. "),
    Blanco("Blanco","Es un tipo de humor muy simple y sano que agrada a la mayoría de las personas."),
    Sarcastico("Sarcastico","De su etimología podemos ver que este tipo de humor se fundamenta en el uso del verbo mordaz, sádico o hiriente para causar gracias a quien lo escucha."),
    Hacker("Hacker","Sin duda, este es un humor muy particular y llamativo, ya que utiliza la realidad tecnológica para hacer reír a los lectores."),
    Crudo("Crudo","Tal y como su nombre indica, es el humor que no teme decir las cosas de forma directa e incluso dolorosa. "),
    Verde("Verde","Este humor está relacionado con temas sexuales. "),
    Negro("Negro","Este tipo de humor es un poco singular porque mezcla sátira, burla, lo grotesco e incluso lo absurdo en una forma de humor que no agrada a todos. ");
    private final String descripcion;

    Humor(String nombreH,String descripcion) {
        this.descripcion = descripcion;
    }

    public void descripcion() {

    }
    public static void mostrarDescripcionesHumor(){
        System.out.println("A continuación se le muestra una lista de los tipos de humor y su descripción:");
        for (Humor item : Humor.values()){
            System.out.println(item.name()+": " + item.descripcion);
        }
    }
}
