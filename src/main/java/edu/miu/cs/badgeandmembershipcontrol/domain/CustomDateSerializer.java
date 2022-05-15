//package edu.miu.cs.badgeandmembershipcontrol.domain;
//
//public class CustomDateSerializer extends StdSerializer<Date> {
//
//    private SimpleDateFormat formatter
//            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//
//    public CustomDateSerializer() {
//        this(null);
//    }
//
//    public CustomDateSerializer(Class t) {
//        super(t);
//    }
//
//    @Override
//    public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
//            throws IOException, JsonProcessingException {
//        gen.writeString(formatter.format(value));
//    }
//}