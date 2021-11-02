package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("001");

        Product product1 = new Product("name1");
        Product product2 = new Product("name2");

        Item item1 = new Item(product1, new BigDecimal(500), 20);
        Item item2 = new Item(product2, new BigDecimal(10), 50);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        invoice.setItems(itemList);

        //When
        invoiceDao.save(invoice);

        Optional<Invoice> read = invoiceDao.findById(invoice.getId());

        //Then
        Assertions.assertTrue(read.isPresent());

        //CleanUp
        invoiceDao.deleteAll();
    }
}
