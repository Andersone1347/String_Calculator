import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        Calcc calcc = new Calcc();
        String res = null;
        if (a.contains("+")) {
            res = calcc.plus(a);
        }
        if (a.contains("-")) {
            res = calcc.minus(a);
        }
        if (a.contains("*")) {
            res = calcc.um(a);
        }
        if (a.contains("/")) {
            res = calcc.del(a);
        }
        if (res.length() > 40) {
            res = res.substring(0, 40);
            System.out.println("\"" + res + "..."+"\"");
        } else {
            System.out.println("\"" + res + "\"");
        }
    }
}

class Calcc {
    public String plus(String a) throws Exception {
        String[] par;
        par = a.split("\\s\\+\\s");

        if (Exeption.checkerFirstStr(par[0])) {
            throw new Exception();
        } else {
            if (Exeption.checkerFirstStr(par[1])) {
                throw new Exception();
            } else {
                RemoveTrash.trashMass(par);
                String a1 = par[0];
                String a2 = par[1];
                if (Exeption.checkerStr(a1, a2)) {
                    throw new Exception();
                } else {
                    a = a1 + a2;
                    return a;
                }
            }
        }
    }
    public String minus(String a) throws Exception {
        String[] par;
        par = a.split("(\\s-\\s)");
        if (Exeption.checkerFirstStr(par[0])) {
            throw new Exception();
        } else {
            if (Exeption.checkerFirstStr(par[1])) {
                throw new Exception();
            } else {
                RemoveTrash.trashMass(par);
                String a1 = par[0];
                String a2 = par[1];
                if (Exeption.checkerStr(a1, a2)) {
                    throw new Exception();
                } else {
                    a1 = a1.replaceAll(a2, "");
                    a = a1;
                    return a;
                }
            }
        }
    }

    public String um(String a) throws Exception {
        String[] par;
        par = a.split("\\s\\*\\s");
        if (Exeption.checkerFirstStr(par[0])) {
            throw new Exception();
        } else {
            if (Exeption.checkerTwoStr(par[1])) {
                throw new Exception();
            } else {
                RemoveTrash.trashMass(par);
                String a1 = par[0];
                String a2 = par[1];

                int b2 = Integer.parseInt(a2);
                if (Exeption.checkerInt(b2)) {
                    throw new Exception();
                } else {
                    String b1 = a1;
                    for (int i = 1; i < b2; i++) {
                        a1 += b1;
                    }
                    a = a1;
                    return a;
                }
            }
        }
    }
    public String del(String a) throws Exception {
        String[] par;
        par = a.split("\\s/\\s");
        if (Exeption.checkerFirstStr(par[0])) {
            throw new Exception();
        } else {
            if (Exeption.checkerTwoStr(par[1])) {
                throw new Exception();
            } else {
                RemoveTrash.trashMass(par);
                String a1 = par[0];
                String a2 = par[1];
                int b2 = Integer.parseInt(a2);
                if (Exeption.checkerInt(b2)) {
                    throw new Exception();
                } else {
                    int b1 = a1.length();
                    int c = b1 / b2;
                    a = a1.substring(0, c);
                    return a;
                }
            }
        }
    }

    class Exeption {
        public static boolean checkerStr(String a, String b) {
            return a.length() < 0 || a.length() > 10 || b.length() < 0 || b.length() > 10;
        }
        public static boolean checkerInt(int a){
            return a < 1 || a > 10;
        }
        public static boolean checkerFirstStr(String a){
            String b,c;
            b = String.valueOf(a.charAt(0));
            c = String.valueOf(a.charAt(a.length()-1));
            if (b.equals(c) && b.contains("\"")){
                return false;
            } else {
                return true;
            }
        }
        public static boolean checkerTwoStr(String a){
            if (a.contains("\"")){
                return true;
            } else {
                return false;
            }
        }
    }

    class RemoveTrash {
        public static String[] trashMass(String[] par) {
            for (int i = 0; i < par.length; i++) {
                par[i] = par[i].replaceAll("\"", "");
            }
            return par;
        }
    }

}

