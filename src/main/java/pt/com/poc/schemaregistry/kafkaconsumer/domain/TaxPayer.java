package pt.com.poc.schemaregistry.kafkaconsumer.domain;

import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecordBase;

import lombok.Data;

@Data
public class TaxPayer extends SpecificRecordBase {

    private String name;
    private String document;
    private Boolean situation;

    @Override
    public Schema getSchema() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Object get(int field) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void put(int field, Object value) {
        // TODO Auto-generated method stub
        
    }

}
