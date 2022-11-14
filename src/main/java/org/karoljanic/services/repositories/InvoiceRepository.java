package org.karoljanic.services.repositories;

import org.karoljanic.models.Invoice;
import org.karoljanic.services.interfaces.IInvoiceRepository;

import java.util.List;

// Cel klasy: implementacja magazynu danych o fakturach
public class InvoiceRepository implements IInvoiceRepository {
    @Override
    public List<Invoice> getAll() {
        return null;
    }

    @Override
    public Invoice getByIdentifier(String invoiceIdentifier) {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public void delete(Invoice invoice) {

    }
}
