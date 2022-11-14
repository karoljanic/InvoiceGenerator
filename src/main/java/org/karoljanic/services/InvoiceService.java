package org.karoljanic.services;

import org.karoljanic.models.Invoice;
import org.karoljanic.services.interfaces.IInvoiceRepository;

import java.util.List;

// Cel klasy: zarzadzanie danymi o fakturach
public class InvoiceService  {
    IInvoiceRepository _invoiceRepository;

    InvoiceService(IInvoiceRepository invoiceRepository) {
        _invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAll() { return _invoiceRepository.getAll(); }
    public Invoice getByIdentifier(String invoiceIdentifier) { return _invoiceRepository.getByIdentifier(invoiceIdentifier); }
    public void save(Invoice invoice) { _invoiceRepository.save(invoice); }
    public void update(Invoice invoice) { _invoiceRepository.update(invoice); }
    public void delete(Invoice invoice) { _invoiceRepository.delete(invoice); }
}
