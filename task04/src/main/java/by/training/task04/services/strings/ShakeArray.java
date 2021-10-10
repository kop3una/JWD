package by.training.task04.services.strings;

public class ShakeArray { //TODO добавить размер текста в генерации
    public void shake(String[][] text) {
        for (int row = 0; row < text.length; row++){
            int a = (int) (Math.random()*text.length);
            int b = (int) (Math.random()*text.length);
            swap(text,a,b);
        }
    }

    private void swap (String[][] text, int a, int b){
        String [] c = text[a];
        text[a] = text [b];
        text[b] = c;
    }
}
