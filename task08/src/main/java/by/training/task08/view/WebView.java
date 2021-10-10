package by.training.task08.view;

import by.training.task08.beans.Candy;
import by.training.task08.beans.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/XMLResult")
public class WebView extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "  <style type=\"text/css\">\n" +
                "   TABLE {\n" +
                "    border-collapse: collapse; /* Убираем двойные границы между ячейками */\n" +
                "    background: #dc0; /* Цвет фона таблицы */\n" +
                "    border: 4px solid #000; /* Рамка вокруг таблицы */\n" +
                "   }\n" +
                "   TD, TH {\n" +
                "    padding: 5px; /* Поля вокруг текста */\n" +
                "    border: 2px solid green; /* Рамка вокруг ячеек */\n" +
                "   }\n" +
                "  </style>\n" +
                " </head>");
        out.println("<h1>"+request.getAttribute("message")+"</h1>");
        out.println("<h2>"+"Выбран парсер: "+request.getAttribute("parser")+"</h2>");
        out.println("<h2>"+request.getAttribute("validation") + "</h2>");
        Result result = (Result) request.getAttribute("result");
        if (result.isState()){
            out.println("<table>\n" +
                    "<tr>\n" +
                    "<td>Название</td>\n" +
                    "<td>Тип</td>\n" +
                    "<td>Калории</td>\n" +
                    "<td>Страна</td>\n" +
                    "<td>Цена</td>\n" +
                    "<td>Жиры</td>\n" +
                    "<td>Белки</td>\n" +
                    "<td>Углеводы</td>\n" +
                    "<td>Изготовитель</td>\n" +
                    "<td>Дата производства</td>\n" +
                    "<td>Вода</td>\n" +
                    "<td>Карамель</td>\n" +
                    "<td>Сахар</td>\n" +
                    "<td>Фруктоза</td>\n" +
                    "<td>Тип Шоколада</td>\n" +
                    "<td>Вес шоколада</td>\n" +
                    "<td>Масло</td>\n" +
                    "<td>Молоко</td>\n" +
                    "<td>Сметана</td>\n" +
                    "<td>Сгущенка</td>\n" +
                    "<td>Яичный белок</td>\n" +
                    "<td>Тип орехов</td>\n" +
                    "<td>Вес орехов</td>\n" +
                    "<td>Желатин</td>\n" +
                    "</tr>");
            for (Candy candy: result.getCandies()){
                out.println( "<tr>\n" +
                        "<td>"+candy.getName()+"</td>\n" +
                        "<td>"+candy.getType()+"</td>\n" +
                        "<td>"+candy.getEnergy()+"</td>\n" +
                        "<td>"+candy.getCountry()+"</td>\n" +
                        "<td>"+candy.getPrice()+"</td>\n" +
                        "<td>"+candy.getValue().getFats()+"</td>\n" +
                        "<td>"+candy.getValue().getProteins()+"</td>\n" +
                        "<td>"+candy.getValue().getCarbohydrates()+"</td>\n" +
                        "<td>"+candy.getProduction()+"</td>\n" +
                        "<td>"+candy.getDateManufactured()+"</td>\n" +
                        "<td>"+candy.getIngredients().getWater()+"</td>\n" +
                        "<td>"+candy.getIngredients().getCaramel()+"</td>\n" +
                        "<td>"+candy.getIngredients().getSugar()+"</td>\n" +
                        "<td>"+candy.getIngredients().getFructose()+"</td>\n" +
                        "<td>"+candy.getIngredients().getChocolate().getTypeChocolate()+"</td>\n" +
                        "<td>"+candy.getIngredients().getChocolate().getWeight()+"</td>\n" +
                        "<td>"+candy.getIngredients().getOil()+"</td>\n" +
                        "<td>"+candy.getIngredients().getMilk()+"</td>\n" +
                        "<td>"+candy.getIngredients().getSourCream()+"</td>\n" +
                        "<td>"+candy.getIngredients().getCondensedMilk()+"</td>\n" +
                        "<td>"+candy.getIngredients().getEggsProtein()+"</td>\n" +
                        "<td>"+candy.getIngredients().getNuts().getTypeNuts()+"</td>\n" +
                        "<td>"+candy.getIngredients().getNuts().getWeight()+"</td>\n" +
                        "<td>"+candy.getIngredients().getGelatin()+"</td>\n" +
                        "</tr>");
            }
            out.println("</table>");
        }

    }
}
