//Llanos Cristian
public class ColaBinomial {
    NodoCB head; // Puntero al primer árbol binomial de la cola
    NodoCB child;
    int Ver = 0 ;
    ColaBinomial(){head=null;} // Constructor



    //==================================================
    //Inserción de un elemento en la cola binomial
    //==================================================
    public  void Insert(int a) {
        ColaBinomial H1 = new ColaBinomial();
        H1.head = new NodoCB(null, null, null, a, (short)0);
        head = BinomialHeapUnion(H1);
    }


    public void print(){
        if(head!=null){
            head.Print(0);
        }
    }


    //====================================================
    //Unión (fusión de dos colas binomiales)
    //====================================================
    private NodoCB BinomialHeapUnion(ColaBinomial H2){
        ColaBinomial H = BinomialHeapMerge(this, H2);
        if(H.head==null) return H.head;
        NodoCB prevx= null;
        NodoCB x = H.head;
        NodoCB nextx=x.sibling;
        while(nextx!=null) {
            if ((x.degree != nextx.degree) ||  (nextx.sibling !=null && nextx.sibling.degree == x.degree)){
                prevx = x;
                x = nextx;
            }
            else if(x.key <= nextx.key) {
                x.sibling= nextx.sibling;
                nextx.BinomialLink(x);
            }
            else {
                if(prevx==null) H.head=nextx;
                else  prevx.sibling= nextx;
                x.BinomialLink(nextx);
                x = nextx;
            }
            nextx = x.sibling;
        }
        return H.head;
    }

    //===========================================================
    // Mezcla de dos colas Binomiales. A partir de dos colas
    // se obtine una tercera que contiene los árboles binomiales
    // de las dos colas ordenados por k
    //===========================================================
    private  ColaBinomial BinomialHeapMerge(ColaBinomial H1, ColaBinomial H2) {
        NodoCB h1 = H1.head;
        NodoCB h2 = H2.head;
        if (h1==null) return H2;
        if (h2==null) return H1;
        ColaBinomial H = new ColaBinomial();
        NodoCB ini = null;
        NodoCB fin= null;
        while(h1!=null && h2!=null) {
            if(h1.degree <= h2.degree) {
                if(ini == null) {ini = fin= h1;}
                else {fin.sibling = h1; fin = h1;}
                h1 = h1.sibling;
            }
            else  {
                if(ini == null) {ini = fin= h2;}
                else {fin.sibling = h2; fin = h2;}
                h2 = h2.sibling;
            }
        }
        if(h1==null) fin.sibling = h2;
        if(h2==null) fin.sibling = h1;
        H.head=ini;
        return  H;
    }

    public int size(){
    int n=0;
    int m=0;
    NodoCB ref=head;
    while(ref != null){
        int sum = (int) Math.pow(2,ref.degree);
            n += sum;
            ref = ref.sibling;
    }
        return n;
    }
    /*
    el costo algorítmico del método size para una cola binomial de 21 nodos es principalmente determinado por la
    complejidad de tiempo, que es O(logN), donde N es el número total de nodos en la cola binomial.
    */
}
