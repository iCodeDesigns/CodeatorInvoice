package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleInvoiceDtlId generated by hbm2java
 */
@Embeddable
public class VcleVehicleInvoiceDtlId  implements java.io.Serializable {


     private String invoiceSp;
     private byte invoiceType;
     private short invoiceSeq;

    public VcleVehicleInvoiceDtlId() {
    }

    public VcleVehicleInvoiceDtlId(String invoiceSp, byte invoiceType, short invoiceSeq) {
       this.invoiceSp = invoiceSp;
       this.invoiceType = invoiceType;
       this.invoiceSeq = invoiceSeq;
    }
   


    @Column(name="INVOICE_SP", nullable=false, length=240)
    public String getInvoiceSp() {
        return this.invoiceSp;
    }
    
    public void setInvoiceSp(String invoiceSp) {
        this.invoiceSp = invoiceSp;
    }


    @Column(name="INVOICE_TYPE", nullable=false, precision=2, scale=0)
    public byte getInvoiceType() {
        return this.invoiceType;
    }
    
    public void setInvoiceType(byte invoiceType) {
        this.invoiceType = invoiceType;
    }


    @Column(name="INVOICE_SEQ", nullable=false, precision=3, scale=0)
    public short getInvoiceSeq() {
        return this.invoiceSeq;
    }
    
    public void setInvoiceSeq(short invoiceSeq) {
        this.invoiceSeq = invoiceSeq;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleInvoiceDtlId) ) return false;
		 VcleVehicleInvoiceDtlId castOther = ( VcleVehicleInvoiceDtlId ) other; 
         
		 return ( (this.getInvoiceSp()==castOther.getInvoiceSp()) || ( this.getInvoiceSp()!=null && castOther.getInvoiceSp()!=null && this.getInvoiceSp().equals(castOther.getInvoiceSp()) ) )
 && (this.getInvoiceType()==castOther.getInvoiceType())
 && (this.getInvoiceSeq()==castOther.getInvoiceSeq());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getInvoiceSp() == null ? 0 : this.getInvoiceSp().hashCode() );
         result = 37 * result + this.getInvoiceType();
         result = 37 * result + this.getInvoiceSeq();
         return result;
   }   


}


