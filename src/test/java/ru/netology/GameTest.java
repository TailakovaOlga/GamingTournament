package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Иван", 200);
    Player player2 = new Player(2, "Егор", 300);
    Player player3 = new Player(3, "Игорь", 100);
    Player player4 = new Player(4, "Юра", 150);
    Player player5 = new Player(5, "Олег", 150);

    Game game = new Game();

    @Test
    public void testFirstPlayer() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Егор", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayer() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Иван", "Егор");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayersEquals() {
        Player Ivan = new Player(4, "Юра", 150);
        Player Egor = new Player(5, "Олег", 150);
        Game game = new Game();

        game.register(Ivan);
        game.register(Egor);
        int actual = game.round("Юра", "Олег");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Игорь");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Егор", "Юра");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Егор");
        });
    }
}
