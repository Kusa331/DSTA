package W3.D2;

/**
 *
 * @author clydebalaman
 */
public class LinkedPositionalListDemo {
    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        Position<Integer> p, q, r, s;
        Integer element;
        
        // Method | Return Value | List Contents
        System.out.println("Method | Return Value | List Contents");
        System.out.println("--------------------------------------");
        
        // addLast(8) | p | (8p)
        p = list.addLast(8);
        System.out.println("addLast(8) | p | " + listContents(list, p, null, null, null));
        
        // first( ) | p | (8p)
        p = list.first();
        System.out.println("first() | p | " + listContents(list, p, null, null, null));
        
        // addAfter(p, 5) | q | (8p, 5q)
        q = list.addAfter(p, 5);
        System.out.println("addAfter(p, 5) | q | " + listContents(list, p, q, null, null));
        
        // before(q) | p | (8p, 5q)
        p = list.before(q);
        System.out.println("before(q) | p | " + listContents(list, p, q, null, null));
        
        // addBefore(q, 3) | r | (8p, 3r, 5q)
        r = list.addBefore(q, 3);
        System.out.println("addBefore(q, 3) | r | " + listContents(list, p, q, r, null));
        
        // r.getElement( ) | 3 | (8p, 3r, 5q)
        element = r.getElement();
        System.out.println("r.getElement() | " + element + " | " + listContents(list, p, q, r, null));
        
        // after(p) | r | (8p, 3r, 5q)
        r = list.after(p);
        System.out.println("after(p) | r | " + listContents(list, p, q, r, null));
        
        // before(p) | null | (8p, 3r, 5q)
        Position<Integer> posBeforeP = list.before(p);
        System.out.println("before(p) | " + posBeforeP + " | " + listContents(list, p, q, r, null));
        
        // addFirst(9) | s | (9s, 8p, 3r, 5q)
        s = list.addFirst(9);
        System.out.println("addFirst(9) | s | " + listContents(list, p, q, r, s));
        
        // remove(last( )) | 5 | (9s, 8p, 3r)
        element = list.remove(list.last());
        System.out.println("remove(last()) | " + element + " | " + listContents(list, p, q, r, s));
        
        // set(p, 7) | 8 | (9s, 7p, 3r)
        element = list.set(p, 7);
        System.out.println("set(p, 7) | " + element + " | " + listContents(list, p, q, r, s));
        
        // remove(q) | “error” | (9s, 7p, 3r)
        try {
            element = list.remove(q);
            System.out.println("remove(q) | " + element + " | " + listContents(list, p, q, r, s));
        } catch (IllegalArgumentException e) {
            System.out.println("remove(q) | \"error\" | " + listContents(list, p, q, r, s));
        }
    }
    
    private static String listContents(LinkedPositionalList<Integer> list, Position<Integer> p, Position<Integer> q, Position<Integer> r, Position<Integer> s) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Position<Integer> pos = list.first();
        while (pos != null) {
            sb.append(pos.getElement());
            if (pos == p) sb.append("p");
            if (pos == q) sb.append("q");
            if (pos == r) sb.append("r");
            if (pos == s) sb.append("s");
            pos = list.after(pos);
            if (pos != null) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}



