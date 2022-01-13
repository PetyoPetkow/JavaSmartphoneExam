# JavaSmartphoneExam
Проектът служи за обработка на данни за смартфони. Състои се от един Main клас, интерфейс Product и модел SmartPhone, като отделяме интерфейсите и моделите в отделни пакети.
Започваме с реализирането на интерфейса Product, като по условие той наследява интерфейса Comparable. За да можем да правим @Override на неговите методи в класовете наследяващи Product, за негов параметър задаваме generic <T>/на мястото на T можем да сможим обект от който и да е клас имплементиращ Product/ . Като методи на Product задаваме getName() от тип String и getPrice() от тип double.

След това създаваме класа SmartPhone. Той имплементира Product, като в тази декларация задаваме в квадратните скоби “Smartphone” на мястото на <Т>. Задаваме си полетата по условие, и конструктор чрез който да ги попълваме. Овъррайдваме методите на интерфейса, като getName() връща конкатенирани марката и модела на телефона, а getPrice()- стойността на полето от класа. Създаваме и get методи за останалите полета, като пишем get и избираме от предложените методи. 

В Main класа създаваме 3 обекта от тип “Smartphone” по следния начин:
SmartPhone smartPhone1 = new SmartPhone(params)
	
	Създаваме списък от тип “SmartPhone” (List<SmartPhones>)
 List<SmartPhone> smartPhones = new ArrayList<>();
	
	и добавяме нащите обекти/smartphones.add(#smartphone name) /.
След което по услови имаме за цел да подредим обектите във възходящ ред според тяхната цена. За целта създаваме @Override на метода compareTo() в класа SmartPhone, който трябва да изглежда по следния начин:
@Override
public int compareTo(SmartPhone s) {
    double otherPrice = s.price;

    if (price == otherPrice)
        return 0;
    else if (price > otherPrice)
        return 1;
    else
        return -1;
}

Той сравнява обектите по зададен параметър и чрез извикване на Collections.sort(smartPhones) в главния (Main) метод, списъкът се подрежда.

След това по задание трябва да изведем този списък в конзолата. За целта създаваме @Override на toString() метода на “SmartPhone”, като използваме “StringBuilder” в който записваме името (получаваме от метода getName()), годината на производство, цвета и цената на телефона. 
@Override
public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append(getName()+ " ");
    builder.append(this.year + " ");
    builder.append(this.color + " ");
    builder.append(this.price) ;

    return builder.toString();
}

След това в главния метод правим foreach за всички смартфони и на всеки цикъл извикваме вече презаписания метод toString() за всеки един.

След това като задание имаме да запишем в нов файл телефона, който е с най голяма цена. За целта може да направим статичен метод, който да приема списака с телефони и да връща най-скъпия от тях. В този метод извършваме проста проверка чрез foreach цикъл: 
SmartPhone mostExpensiveSmartphone = null;
for (SmartPhone s:smartPhones
     ) {
    if (mostExpensiveSmartphone==null||mostExpensiveSmartphone.getPrice()<s.getPrice()){
        mostExpensiveSmartphone=s;
    }
}

И като резултат връщаме “mostExpensiveSmartphone”.
	Този метод задаваме като аргумент на друг метод/в случая“saveTheMostExpensiveSmartphoneInATextFile(SmartPhone smartphone)“/, който създаваме за да запишем стойностите на обекта във файл.
	В него си отваряме BufferedReader по този начин:
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

След което в tryCatch изискваме да се въведе име за файла в конзолата което запазваме в променливата “fileName” чрез “reader.readLine()“. След това си създаваме “PrintWriter”, в който задаваме нова инстанция на “”BufferedWriter, a в него нова на „FileWriter“.
Резултата изглежда по този начин:
PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

След това извикваме методите println(#smartphone) и close на writer-a който създадохме и също така затваряме и reader-a. 
Последното нещо, което трябва да направим в “Main” e използваме методите, които току що създадохме за да запишем резултата.
saveTheMostExpensiveSmartphoneInATextFile(getTheMostExpensiveSmartphone(smartPhones));


