package org.karoljanic.services.repositories;

import org.karoljanic.models.InvoicePart;
import org.karoljanic.services.interfaces.IInvoicePartRepository;

import java.util.List;

// Cel klasy: implementacja magazynu danych o czesciach faktur
public class InvoicePartRepository implements IInvoicePartRepository {
    @Override
    public List<InvoicePart> getAll() {
        return null;
    }

    @Override
    public InvoicePart getByIdentifier(String invoicePartIdentifier) {
        return null;
    }

    @Override
    public void save(InvoicePart invoicePart) {

    }

    @Override
    public void update(InvoicePart invoicePart) {

    }

    @Override
    public void delete(InvoicePart invoicePart) {

    }
}
