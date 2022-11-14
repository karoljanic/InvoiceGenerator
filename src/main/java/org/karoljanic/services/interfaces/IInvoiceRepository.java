package org.karoljanic.services.interfaces;

import org.karoljanic.models.Invoice;

import java.util.List;

// Cel klasy: implementacja interface'u magazynu danych o fakturach
public interface IInvoiceRepository {
    List<Invoice> getAll();
    Invoice getByIdentifier(String invoiceIdentifier);
    void save(Invoice invoice);
    void update(Invoice invoice);
    void delete(Invoice invoice);
}
