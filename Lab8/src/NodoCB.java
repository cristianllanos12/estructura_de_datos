//Llanos Cristian
public class NodoCB {
    NodoCB p; // El padre
    NodoCB sibling; // el hermano
    NodoCB child;  // el hijo
    Integer key;  // la clave
    Short  degree; // el grado.
    //============================
    //Constructor
    //============================
    NodoCB(NodoCB p, NodoCB sibling,
           NodoCB child, Integer key,
           Short degree){
        this.p=p; this.sibling=sibling;
        this.child = child; this.key = key;
        this.degree = degree;
    }
    //===============================
    //Une dos binomiales árboles B_k
    //===============================
    void  BinomialLink(NodoCB z){
        p =z;
        sibling = z.child;
        z.child= this;
        z.degree++;
    }

    public void Print(int a){
        NodoCB C = this;
        while(C!= null){
            StringBuilder SB = new StringBuilder();
            for (int i=0;i<a; i++){
                SB.append("  ");
            }
        SB.append(C.key.toString());
            System.out.println(SB.toString());
            if(C.child != null){
                C.child.Print(a+1);
            }
        C = C.sibling;
        }

    }
}
