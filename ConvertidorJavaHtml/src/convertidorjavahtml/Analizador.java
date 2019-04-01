package convertidorjavahtml;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

/**
 *
 * @author kirk
 */

public class Analizador {
    String[] pr = new String[50];
    String[] var = new String[8];
    LinkedList<String> pal = new LinkedList();
    String pr1 = "<span cla-ss='pr'>";
    String pr2 = "</span>";
    
    FileDialog filetmp;
    Menu menu;
    File file;
    FileReader fr;
    BufferedReader br;
    String nameFile = "";
    int cont = 0;
    
    public Analizador(){
        llenarArray();
        /*
        this.pr[0] = "abstract";
        this.pr[1] = "assert";
        this.pr[2] = "boolean";
        this.pr[3] = "break";
        this.pr[4] = "byte";
        this.pr[5] = "case";
        this.pr[6] = "catch";
        this.pr[7] = "char";
        this.pr[8] = "class";
        this.pr[9] = "const";
        
        this.pr[10] = "continue";
        this.pr[11] = "default";
        this.pr[12] = "do";
        this.pr[13] = "double";
        this.pr[14] = "else";
        this.pr[15] = "enum";
        this.pr[16] = "extends";
        this.pr[17] = "final";
        this.pr[18] = "finally";
        this.pr[19] = "float";
        
        this.pr[20] = "for";
        this.pr[21] = "goto";
        this.pr[22] = "if";
        this.pr[23] = "implements";
        this.pr[24] = "import";
        this.pr[25] = "instanceof";
        this.pr[26] = "int";
        this.pr[27] = "interface";
        this.pr[28] = "long";
        this.pr[29] = "native";
        
        this.pr[30] = "new";
        this.pr[31] = "package";
        this.pr[32] = "private";
        this.pr[33] = "protected";
        this.pr[34] = "public";
        this.pr[35] = "return";
        this.pr[36] = "short";
        this.pr[37] = "static";
        this.pr[38] = "strictfp";
        this.pr[39] = "super";
        
        this.pr[40] = "switch";
        this.pr[41] = "synchronized";
        this.pr[42] = "this";
        this.pr[43] = "throw";
        this.pr[44] = "throws";
        this.pr[45] = "transient";
        this.pr[46] = "try";
        this.pr[47] = "void";
        this.pr[48] = "volatile";
        this.pr[49] = "while";
        */
        this.var[0] = "String";
        this.var[1] = "int";
        this.var[2] = "Integer";
        this.var[3] = "Double";
        this.var[4] = "double";
        this.var[5] = "return";
        this.var[6] = "+";
        this.var[7] = "Date";
        //this.var[8] = "=";
        
    }
    
    public String analizar(String text){
        llenarArray();
        text = text.replace("\n", " MAYORQUE br/ MENORQUE ");
        text = text.replace("\t", " TAB ");
        String[] tmp = text.split(" ");
        String value = "";
        String value2 = "";
        
        boolean var = false;
        boolean thisOption = false;
        boolean mayorMenor = false;
        boolean comentario = false;

        for (int i = 0; i < tmp.length; i++) {
            System.out.println("Analizando: "+tmp[i]);
            if (buscarPalabraReservada(tmp[i])) {
                //System.out.println("Entre a las palabras reservadas");
                text = text.replace(tmp[i], pr1+tmp[i]+pr2);
                pal.remove(tmp[i]);
            }else{
                if (var) {
                    for (int j = 0; j < tmp[i].length(); j++) {
                        if(tmp[i].charAt(j)!=';'){
                            value += tmp[i].charAt(j);
                            //System.out.println(value);
                        }else{
                            break;
                        }
                    }

                    //value = value;
                    //System.out.println("buscando: "+value+" status: "+ m.find());
                    text = text.replace(value+";", "<span cla-ss='var'>"+value+"</span>;");
                    var = false;
                    value = "";
                }
                if (buscarVar(tmp[i])) {
                    //System.out.println("asdfghsa");
                    var = true;
                }
                
                for (int j = 0; j < tmp[i].length(); j++) { // evaluamos un this
                    value2+=tmp[i].charAt(j);
                    //System.out.println(value2);
                    if (j == 4) {
                        if (value2.equals("this.")) {
                            System.out.println("Encontrado un this...");
                            thisOption = true;
                            value2 = "";
                        }
                    }
                }
                if (thisOption) {
                    System.out.println("var encontrada: "+value2);
                    text = text.replace(tmp[i], "<span cla-ss='pr'>this</span>."+"<span cla-ss='var'>"+value2+"</span>");
                    thisOption = false;
                }
                value2 = "";
                for (int j = 0; j < tmp[i].length(); j++) { // evaluamos si hay algun < >
                    //System.out.println("item: "+tmp[i].charAt(j));
                    if (tmp[i].charAt(j)!='<') {
                        if (tmp[i].charAt(j)!='>') {
                            value2+=tmp[i].charAt(j);
                        }else{
                            System.out.println("Se ha encontrado un > y se a remplazado");
                            value2 = value2+"&gt;";
                            mayorMenor = true;
                        }
                        //value2+=tmp[i].charAt(j);
                    }else{
                        System.out.println("Se ha encontrado un < y se a remplazado");
                        value2 = value2+"&lt;";
                        mayorMenor = true;
                    }
                    
                }   
                if (mayorMenor) {
                    System.out.println("Valor del value2: "+value2);
                    text = text.replace(tmp[i], value2);
                    mayorMenor = false;
                }

                //System.out.println("valor value2: "+value2);
                value2 = "";
                if (!comentario) {
                    if (tmp[i].equals("/**")) {
                        System.out.println("See ha encontrado un comentario");
                        text = text.replace(tmp[i], "<span cla-ss='com-multi'>/**");
                    }
                    if (tmp[i].equals("*/")) {
                        System.out.println("Se ha cerrado el comentario");
                        text = text.replace(tmp[i], "*/</span>");
                        comentario = true;
                    }
                }

                /*
                for (int j = 0; j < tmp[i].length(); j++) { // evaluamos si es un cometario
                    value2+=tmp[i].charAt(j);
                    if (j == 1) {
                        if (value2.equals("//")) {
                            System.out.println("comentario encontrado");
                            text = text.replace(tmp[i], "<span cla-ss='com'>"+tmp[i]+"</span>");
                        }
                    }
                }
                value2 = ""; 
                */
                //System.out.println("no soy PR soy "+tmp[i]);
                
                /*
                Pattern p = Pattern.compile("(\\W)([a-z]*)");
                Matcher m = p.matcher(tmp[i]);
                //if (m.find()) {
                    while(m.find()){
                        for (int k = m.start(); k < m.end(); k++) {
                            //System.out.println("este mero: "+tmp[i].charAt(k));
                            //m.
                            value += tmp[i].charAt(k);
                        }
                    }
                    value = value+";";
                    System.out.println("buscando: "+value+" status: "+ m.find());
                    text = text.replace(value, "<span cla-ss='var'>"+value+"</span>;");
                    value = "";
                    
                //}
                */
            }
            
            /*
            for (int j = 0; j < pr.length; j++) {
                if (tmp[i].equals(pr[j])) {
                    text = text.replace(pr[j], pr1+pr[j]+pr2);
                }else{
                    
                    System.out.println("no soy PR soy "+tmp[i]);
                    Pattern p = Pattern.compile("^[a-z]*");
                    Matcher m = p.matcher(tmp[i]);
                    //if (m.find()) {
                        while(m.find()){
                            for (int k = m.start(); k < m.end(); k++) {
                                //System.out.println("este mero: "+tmp[i].charAt(k));
                                //m.
                                value += tmp[i].charAt(k);
                            }
                        }
                        value = value+";";
                        System.out.println("buscando: "+value);
                        text = text.replace(value, "<span cla-ss='var'>"+value+"</span>;");
                        value = "";
                    //}
                }
            }
            */
        }
        text = formatear(text);
        return text;
    }
    
    public boolean buscarPalabraReservada(String palabra){
        for (String pr: pal){
            if (pr.equals(palabra)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarVar(String value){
        for(String tmp : var){
            if (tmp.equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public String formatear(String text){
        System.out.println("Formateando...");
        text = text.replace("cla-ss", "class");
        
        text = text.replace("MAYORQUE", "<");
        text = text.replace("MENORQUE", ">");
        text = text.replace(" < ", "<");
        //text = text.replace("< ", "<");
        //text = text.replace(" <", "<");
        
        text = text.replace(" > ", ">");
        //text = text.replace(" >", ">");
        //text = text.replace("> ", ">");
        
        text = text.replace("TAB", "<span class='tab'></span>");
        
        //String[] tmp = text.split(" ");
        //boolean tab = false;
        
//        for (String temp : tmp){
//            //System.out.println(temp+"");
//            if (temp.equals("TAB")) {
//                tab = true;
//            }
////            
////            if(tab){
////                for (int i = 0; i < temp.length(); i++) {
////                    if (temp.charAt(i) == ';') {
////                        System.out.println("Encontre un ;");
////                        tab = false;
////                    }
////                    
////                }
////                
////            }
//            
//        }
//        
        return text;
    }
    
    public String abrirArchivo(){
        filetmp = new FileDialog(menu, "Abrir archivo",FileDialog.LOAD);
        filetmp.setFile("*.txt");
        filetmp.setVisible(true);
        nameFile = filetmp.getFile();
        
        String ruta = filetmp.getDirectory();
        file = new File(ruta+""+nameFile);
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String texto;
            String tmp="";
            int leng = 0;
            try {
                while((texto=br.readLine())!=null ){
                    leng++;
                    tmp = tmp + texto;
                }
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                tmp = "";
                while((texto=br.readLine())!=null){
                    cont++;
                    if (cont == leng) {
                        tmp = tmp + texto;
                    }else{
                        tmp = tmp + texto+"\n";
                    }
                }
            } catch (IOException ex) {
                System.out.println("Nota: "+ex);
            }
            //clean(tmp);
            
            return tmp;
        } catch (FileNotFoundException ex) {
            System.out.println("Nota: "+ex);
        }
        return "No se abrio el archivo";
        
    }

    public void llenarArray(){
        while(pal.size() != 0){
            pal.remove();
        }
        pal.add("abstract");
        pal.add("assert");
        pal.add("boolean");
        pal.add("break");
        pal.add("byte");
        pal.add("case");
        pal.add("catch");
        pal.add("char");
        pal.add("class");
        pal.add("const");

        pal.add("continue");       
        pal.add("default");
        pal.add("do");
        pal.add("double");
        pal.add("else");
        pal.add("enum");
        pal.add("extends");
        pal.add("final");
        pal.add("finally");
        pal.add("float");

        pal.add("for");
        pal.add("goto");
        pal.add("if");
        pal.add("implements");
        pal.add("import");
        pal.add("instanceof");
        pal.add("int");
        pal.add("interface");
        pal.add("long");
        pal.add("native");

        pal.add("new");
        pal.add("package");
        pal.add("private");
        pal.add("protected");
        pal.add("public");
        pal.add("return");
        pal.add("short");
        pal.add("static");
        pal.add("strictfp");
        pal.add("super");

        pal.add("switch");
        pal.add("synchronized");
        pal.add("this");
        pal.add("throw");
        pal.add("throws");
        pal.add("transient");
        pal.add("try");
        pal.add("void");
        pal.add("volatile");
        pal.add("while");
        pal.add("null");
           
    }
    
    
}
