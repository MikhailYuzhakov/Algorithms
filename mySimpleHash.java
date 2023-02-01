import java.util.ArrayList;

/**
 * mySimpleHash
 */
public class mySimpleHash {

    public static void main(String[] args) {
        String message = "Hello my name yuzhakov mihail and etc";
        System.out.println("Message = " + message + "\nHash = " + myHash.getHash(message));
    }

    /**
     * InnermySimpleHash
     */
    public class myHash {
    
        public static String getHash(String message) {
            ArrayList<Integer> hash = new ArrayList<>();
            String strHash = "";
            // преобразуем строку в массив значений символов в кодировке ascii
            char charArray[] = message.toCharArray();
            for (char c : charArray) {
                hash.add((int)c);
            }
            // если длина входного сообщения меньше заданной, то дополняем сообщения символами по правилу
            if (hash.size() <= 4) {
                for (int j = hash.size(); j < 5; j++) {
                    hash.add(hash.get(j-2) >> 2); 
                }
            }

            int i = 0;
            while (hash.size() > 4) {
                hash.set(i, hash.get(i) ^ hash.get(i+1)); //берем два очередных элемента и делаем XOR и записываем в позицию первого из взятых
                hash.remove(i+1); //удаляем второй из взятых двух элементов
                //условие сброса счетчика на позицию начала массива
                if (i + 2 >= hash.size()) i = 0;
                else i++;
            }
            
            // складываем полученный хэш в строку и возвращаем
            for (Integer item : hash) {
                strHash += String.format("%2X", item);
            }
            return strHash;
        }
    }
}