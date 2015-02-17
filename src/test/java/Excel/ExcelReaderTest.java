package Excel;

/**
 * Created by alexandre on 05/02/2015.
 * */


public class ExcelReaderTest {
    private static final String SHORT_TERM = "SHORT_TERM";
    private static final String LONG_TERM = "LONG_TERM";
    private static final String NOMINATIVE =  "NOMINATIVE";
    private static final String EFFECTIVE = "EFFECTIVE";
    private static final String OCDE_FILE = "OCDE_file.xls";

/*    @Test
    public void shouldTakeWorkbook(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader("Nofile.xls");
            assertThat(false).isTrue();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            assertThat(true).isTrue();
            e.printStackTrace();
        }
    }


    @Test
    public void shouldTakeALineWithSheetAndRowInString(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 1);
            assertThat(ligne).containsOnly("5,0","6,2","4,9","4,7","4,9","5,5","5,6","6,0","6,7","7,0","3,4","4,7","4,8","3,7","2,7","2,4","2,5");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInStringWithoutNull(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 2);
            assertThat(ligne).containsOnly("...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInDouble(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<Double> ligne = new ArrayList<Double>();
            ligne = excelReader.takeLineDouble(0,1);
            assertThat(ligne).contains(5.0,6.2,4.9,4.7,4.9,5.5,5.6,6.0,6.7,2.4,2.5);
            assertThat(ligne).doesNotContain(-1.0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeCountryFromFirstSheet(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<String> country = new ArrayList<String>();
            country = excelReader.getAllCountry();
            assertThat(country).contains("Australie", "Autriche", "Belgique", "Etats-Unis");
            assertThat(country).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeYearsFromFirstSheet(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<String> years = new ArrayList<String>();
            years = excelReader.getAllYears();
            assertThat(years).contains("1999","2000","2002","2015");
            assertThat(years).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeNumberOfLineForSheet(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            int allLine;
            allLine = excelReader.takeNumberOfLine(0);
            assertThat(allLine).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllLineFromASheetInString(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<ArrayList<String>> allLine = new ArrayList<ArrayList<String>>();
            allLine = excelReader.takeAllLineString(0);
            for (ArrayList<String> collect : allLine) {
                System.out.println("collect = " + collect);
                assertThat(collect).doesNotContain("");
            }
            assertThat(allLine.size()).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllSheetLineInString() {
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<ArrayList<ArrayList<String>>> allSheetLine = new ArrayList<ArrayList<ArrayList<String>>>();
            allSheetLine = excelReader.takeAllSheetLineString();
            for (ArrayList<ArrayList<String>> sheetLists : allSheetLine) {
                System.out.println("NewSheet!");
                for (ArrayList<String> LineList : sheetLists) {
                    System.out.println("LineList = " + LineList);
                    assertThat(LineList).doesNotContain("");
                }
            }
            assertThat(allSheetLine.size()).isEqualTo(4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllLineFromASheetInDouble(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<ArrayList<Double>> allLine = new ArrayList<ArrayList<Double>>();
            allLine = excelReader.takeAllLineDouble(0);
            for (ArrayList<Double> collect : allLine) {
                System.out.println("collect = " + collect);
            }
            assertThat(allLine.size()).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllSheetLineInDouble() {
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            Collection<ArrayList<ArrayList<Double>>> allSheetLine = new ArrayList<ArrayList<ArrayList<Double>>>();
            allSheetLine = excelReader.takeAllSheetLineDouble();
            for (ArrayList<ArrayList<Double>> sheetLists : allSheetLine) {
                System.out.println("NewSheet!");
                for (ArrayList<Double> LineList : sheetLists) {
                    System.out.println("LineList = " + LineList);
                }
                assertThat(sheetLists.size()).isEqualTo(34);
            }
            assertThat(allSheetLine.size()).isEqualTo(4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetCountryForACell(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            int x =1,y=1;
            String countryFound = excelReader.getCountry(y);
            assertThat(countryFound).isEqualTo("Australie");
            x =2; y=5;
            String countryFound2 = excelReader.getCountry(y);
            assertThat(countryFound2).isEqualTo("Chili");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetYearForACell(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            int x =1,y=1;
            String yearFound = excelReader.getYear(x);
            assertThat(yearFound).isEqualTo("1999");
            x =2; y=5;
            String yearFound2 = excelReader.getYear(x);
            assertThat(yearFound2).isEqualTo("2000");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetAllNameSheet(){
        try {
            Collection<String> allNameSheet = new ArrayList<String>();
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            allNameSheet = excelReader.getAllNameSheet();
            assertThat(allNameSheet).containsOnly(SHORT_TERM, LONG_TERM, NOMINATIVE, EFFECTIVE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetNameSheet(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            String found = excelReader.getNameSheet(0);
            assertThat(found).isEqualTo(SHORT_TERM);
            String found2 = excelReader.getNameSheet(2);
            assertThat(found2).isEqualTo(NOMINATIVE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetAUniteMonetaire(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            String found = excelReader.getUniteMonetaire(4);
            assertThat(found).isEqualTo("Dollar");
            String found2 = excelReader.getUniteMonetaire(5);
            assertThat(found2).isEqualTo("Peso");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldGetAUniteMonetaireExceptionTitle() throws IOException, BiffException {
        FileReader excelReader = new ExcelReaderImpl();
        excelReader.takeReader(OCDE_FILE);
            String foundnull = excelReader.getUniteMonetaire(0);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldGetAUniteMonetaireExceptionIndex() throws IOException, BiffException {
        FileReader excelReader = new ExcelReaderImpl();
        excelReader.takeReader(OCDE_FILE);
        String foundnull2 = excelReader.getUniteMonetaire(45);
    }

    @Test
    public void shouldGetAllUniteMonetaire(){
        try {
            FileReader excelReader = new ExcelReaderImpl();
            excelReader.takeReader(OCDE_FILE);
            ArrayList<String> found = excelReader.getAllUniteMonetaire();
            assertThat(found).containsOnly("Euro", "Dollar", "Peso", "Couronne", "Forint", "Sheqel", "Yen", "Won", "Zloty", "Tolar", "Franc", "Lire", "Livre");
            assertThat(found).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }*/
}
