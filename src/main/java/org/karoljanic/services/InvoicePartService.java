package org.karoljanic.services;

import org.karoljanic.models.InvoicePart;
import org.karoljanic.services.interfaces.IInvoicePartRepository;

import java.util.List;

// Cel klasy: zarzadzanie danymi o czesciach faktur
public class InvoicePartService {
    private final IInvoicePartRepository _invoicePartRepository;

    public InvoicePartService(IInvoicePartRepository invoicePartRepository) {
        _invoicePartRepository = invoicePartRepository;
    }

    public List<InvoicePart> getAll() { return _invoicePartRepository.getAll(); }
    public InvoicePart getByIdentifier(String invoicePartIdentifier) { return _invoicePartRepository.getByIdentifier(invoicePartIdentifier); }
    public void save(InvoicePart invoicePart) { _invoicePartRepository.save(invoicePart); }
    public void update(InvoicePart invoicePart) { _invoicePartRepository.update(invoicePart); }
    public void delete(InvoicePart invoicePart) { _invoicePartRepository.delete(invoicePart); }
}
