package bruteforce;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Lucas Su
 * @create 2023-08-16-14:03
 */
public class Question1 {
    public static List<List<Long>> generateCombinations(List<Long> n) {
        List<List<Long>> result = new ArrayList<>();
        generateCombinationsHelper(n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(List<Long> n, int start, List<Long> current, List<List<Long>> result) {
        if (current.size() == 3) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < n.size(); i++) {
            current.add(n.get(i));
            generateCombinationsHelper(n, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    // judge
    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeTriplet(List<Long> n) {
        List<List<Long>> combinations = generateCombinations(n);
//        Set set = new HashSet<>();
        int res = 0;
        Long target = 0L;
        for (int i = 0; i < combinations.size(); i++) {
            List<Long> combine = combinations.get(i);
            if(combine.contains(1L)){
                combine.remove(1L);

                if(combine.contains(1L)){
                    combine.remove(1L);
                    target = combine.get(0);

                    if(isPrime(target)){
                        res ++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Long[] array = {1L, 3L, 5L, 7L, 11L, 13L, 17L, 1L, 19L, 23L, 29L, 31L};
        List<Long> list = Arrays.asList(array);
        System.out.println(countPrimeTriplet(list));

        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 3L, 4289L, 5L, 7L, 1021L, 11L, 3019L, 967L, 17L, 923L, 19L, 29L, 31L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                1L, 3L, 5L, 4673L, 7L, 1217L, 11L, 13L, 1L, 2543L, 17L, 19L, 23L, 29L, 821L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 3L, 4643L, 5L, 7L, 9311L, 1171L, 2027L, 11L, 13L, 17L, 19L, 2473L, 2129L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                1L, 2347L, 1L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 7481L, 5647L, 31L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 3L, 4129L, 5L, 7L, 1399L, 4327L, 8713L, 11L, 13L, 17L, 19L, 23L, 9983L, 8971L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                1L, 3L, 723226807416245459L, 2L, 739972444344274363L, 7L, 5L, 11L, 13L, 169917336923781151L, 17L, 19L, 987223004210710331L, 376834422262171399L, 23L, 29L, 1L, 31L, 37L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 294589784991461689L, 3L, 359087329106418229L, 5L, 7L, 565571075242943507L, 11L, 13L, 920970999126726979L, 17L, 19L, 710194101483294751L, 970093981381389251L, 556348586753427287L, 23L, 29L, 31L, 37L, 41L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                561325539269875847L, 467553833883105737L, 174545849082960241L, 818310483624095489L, 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 1L, 29L, 428193534162129107L, 954243130743585217L, 31L, 37L, 1L, 41L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                3L, 380597290666960121L, 5L, 7L, 876025983958399961L, 11L, 13L, 254379103870810549L, 17L, 19L, 924332569386582269L, 491830154963583209L, 23L, 29L, 1L, 31L, 37L, 198714392410133029L, 1L, 41L, 43L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                542199767432699813L, 777802938716202353L, 212811997458829949L, 633783071857165753L, 533313557535144863L, 2L, 3L, 5L, 7L, 890156159572285607L, 592943765603823229L, 11L, 13L, 17L, 19L, 23L, 29L, 506549493724652201L, 31L, 37L, 467789808681792097L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 3L, 5L, 673964350278421231L, 7L, 570852327064636369L, 11L, 13L, 17L, 19L, 100529311121033219L, 782905267445065939L, 220494211474505791L, 23L, 29L, 31L, 37L, 41L, 453200337385175791L, 1L, 1L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                897755467895795269L, 712518787676852867L, 2L, 3L, 5L, 7L, 11L, 13L, 167457552962765929L, 785318264549791391L, 519695709762146947L, 235664032771761491L, 17L, 19L, 23L, 686301435895832203L, 29L, 31L, 135494377082075023L, 1L, 37L, 1L, 41L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 276928791662738263L, 3L, 154706813960393137L, 5L, 677522714231077789L, 7L, 847393503652079827L, 429007505304621623L, 580613740587896963L, 830333069581984819L, 11L, 13L, 17L, 338200654917516311L, 19L, 23L, 791488592359165213L, 699476185102200133L, 29L, 31L, 214902385940531323L, 1L, 37L, 1L, 41L, 43L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                547324030460904911L, 2L, 242396078936426879L, 3L, 174160645112100077L, 5L, 756260982850495393L, 7L, 11L, 13L, 285032243509355101L, 17L, 231769208562727523L, 19L, 244224781588206871L, 23L, 29L, 340255250467333219L, 31L, 37L, 665453238385590779L, 41L, 43L, 1L, 47L, 1L, 53L, 59L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 180754170614523281L, 994088034025083043L, 3L, 5L, 500316715813742939L, 7L, 11L, 13L, 17L, 19L, 804886532361322069L, 240035844062540969L, 23L, 29L, 163131102228287173L, 31L, 37L, 225746466150511693L, 41L, 43L, 231899900411438251L, 47L, 748082880400673899L, 1L, 1L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                310785949449602293L, 237921582705770603L, 2L, 3L, 5L, 582063826368886079L, 7L, 275087005057190617L, 11L, 861900284925848383L, 13L, 616598029020261121L, 17L, 145645825520243639L, 19L, 717107908895557243L, 23L, 293679483397604107L, 250548046658158313L, 29L, 31L, 37L, 612502205445612343L, 41L, 1L, 43L, 1L, 47L, 53L, 59L
        ))));
        System.out.println(countPrimeTriplet(new ArrayList<>(Arrays.asList(
                2L, 3L, 879272409632603453L, 5L, 725211450611275153L, 7L, 135730094775525343L, 11L, 13L, 563794758677534911L, 17L, 19L, 23L, 29L, 406058158390879763L, 686768933549124061L, 31L, 37L, 751333681358862757L, 41L, 465185147290317199L, 43L, 47L, 282224429542246151L, 53L, 59L, 1L, 63L, 1L, 67L, 71L, 73L
        ))));
    }
}
