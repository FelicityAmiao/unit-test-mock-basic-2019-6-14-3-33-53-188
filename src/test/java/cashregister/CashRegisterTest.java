package cashregister;


import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = new Purchase(new Item[]{new Item("a", 1.0)});
        CashRegister cashRegister = new CashRegister(printer);
        //when
        cashRegister.process(purchase);
        //then
        verify(printer, times(1)).print("a\t1.0\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(purchase.asString()).thenReturn("Hello");
        //when
        cashRegister.process(purchase);
        //then
        verify(printer, never()).print("");
        verify(printer, times(1)).print("Hello");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = mock(Purchase.class);
        //when
        cashRegister.process(purchase);
        //then
        verify(printer).print(purchase.asString());
    }

}
