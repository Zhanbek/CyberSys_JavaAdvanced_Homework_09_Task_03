import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static void printHorizontalBorder() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Пригоди Тома Сойєра", "Марк Твен", 445));
        books.add(new Book("Кобзар", "Тарас Шевченко", 245));
        books.add(new Book("Вечори на хуторі близь Диканьки", "Микола Гоголь", 600));

        System.out.println();
        System.out.println("Список книг до фільтрації: ");
        printHorizontalBorder();
        books.stream().forEach(System.out::println);
        printHorizontalBorder();

        int minPages = 500; // ← змінна для замикання

        System.out.println();
        System.out.println("Застосування анонімного класу:");

        Predicate<Book> predicateByAnonymClass = new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                return book.getPages() > minPages; // використовуємо зовнішню змінну
            }
        };

        printHorizontalBorder();
        books.stream()
                .filter(predicateByAnonymClass)
                .forEach(System.out::println);
        printHorizontalBorder();

        System.out.println();
        System.out.println("Застосування лямбда-вираження: ");

        Predicate<Book> predicateByLambdaExpr = book -> book.getPages() > minPages;

        printHorizontalBorder();
        books.stream()
                .filter(predicateByLambdaExpr)
                .forEach(System.out::println);
        printHorizontalBorder();
    }
}
