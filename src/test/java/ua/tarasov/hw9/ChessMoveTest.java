package ua.tarasov.hw9;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ChessMoveTest {

    @Mock
    public ConverterChessCoordinatesToIndexes converter;

    ChessKnight validate = new ChessKnight();
    ChessMove start = new ChessMove();
    @InjectMocks
    public ChessMove finish = new ChessMove("b3");

    @Test
    public void validateMove_trueMove() {

        Mockito.when(converter.getIndexI()).thenReturn(8);
        Mockito.when(converter.getIndexJ()).thenReturn(2);
        boolean result = validate.checkTurn(start.indexI, start.indexJ, finish.indexI, finish.indexJ);
        Assert.assertTrue(result);
    }


    @Test
    public void validateMove_falseMove() {

        Mockito.when(converter.getIndexI()).thenReturn(8);
        Mockito.when(converter.getIndexJ()).thenReturn(5);
        boolean result = validate.checkTurn(start.indexI, start.indexJ, 8, 5);
        Assert.assertFalse(result);
    }
    @Test
    public void validateMove_outsideTheChessboard() {

        Mockito.when(converter.getIndexI()).thenReturn(-1);
        Mockito.when(converter.getIndexJ()).thenReturn(5);
        boolean result = validate.checkTurn(start.indexI, start.indexJ, -1, 5);
        Assert.assertFalse(result);
    }
}
