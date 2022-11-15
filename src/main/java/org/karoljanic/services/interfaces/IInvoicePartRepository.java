package org.karoljanic.services.interfaces;

import org.karoljanic.models.InvoicePart;

import java.util.List;

// Cel klasy: implementacja interface'u magazynu danych o czesciach faktur
public interface IInvoicePartRepository {
    List<InvoicePart> getAll();
    InvoicePart getByIdentifier(String invoicePartIdentifier);
    void save(InvoicePart invoicePart);
    void update(InvoicePart invoicePart);
    void delete(InvoicePart invoicePart);
}
