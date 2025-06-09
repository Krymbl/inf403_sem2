//package Unknown;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataReader {
//
//    public static void main(String[] args) {
//        new DataReader().readFile("med.csv");
//    }
//
//    public List<RawRow> readFile(String fileName) {
//        List<RawRow> result = new ArrayList<>();
//        File file = new File(fileName);
//        if (!file.exists() || !file.isFile()) return result;
//
//        try (
////            InputStream is = new FileInputStream(file);
////            Reader reader = new InputStreamReader(is);
////            BufferedReader br = new BufferedReader(reader)
//                BufferedReader br = new BufferedReader(new FileReader(file))
//
//        ) {
//            while (br.ready()) {
//                //System.out.print((char)reader.read());
//                String[] data = br.readLine().split(";");
//                RawRow raw = new RawRow();
//                raw.setRiskScoreCVRM(data[6]);
//                raw.setMdrd(data[7]);
//                raw.setGlucoseFasting(data[9]);
//                raw.setTotalCholesterol(data[11]);
//                raw.setSystolicBloodPressure(data[13]);
//                raw.setDiastolicBloodPressure(data[14]);
//                raw.setBmi(data[16]);
//                raw.setPsCVRM(data[18]);
//                raw.setSmokingStatus(data[19]);
//                raw.setAge(data[22]);
//                raw.setHypertension(data[23]);
//                result.add(raw);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public List<Row> clearData(List<RawRow> raw) {
//        raw.stream();
//    }
//}