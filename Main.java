import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args) throws SQLException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
            DBInPark data2 = new DBInPark();
                Departure data3 = new Departure();
                    Arrival data4 = new Arrival();
                        Delete data5 = new Delete();
                            Changes data6 = new Changes();

        int count_bus = 0;
        int count_attempt = 3;
        String number, name;
        for (int a = 0; a<count_attempt; a++)
        {
            System.out.println("--Выберите количество автобусов в парке на сегодняшний день:");
                count_bus = sc.nextInt();
            if (count_bus >= 1 & count_bus <= 100)
            {
                for (int i = 0; i < count_bus; i++)
                {
                    sc.nextLine();
                    System.out.println("--Введите номер автобуса:");
                    number = sc.nextLine();
                    data2.setNumber(number);
                    System.out.println("--Введите фамилию и.о. водителя:");
                    name = sc.nextLine();
                    data2.setName(name);
                    data2.insertIn();
                }
                break;
            }
            else
            {
                System.out.println("-!-!-ERROR: вводимое число автобусов не верно-!-!- (Повторите попытку еще раз)\n");
            }
            if (a==2)
            {
                System.out.println("Вы превысили количество допустимых попыток");
                    System.exit(0);
            }
        }
        data2.getBusIn();
        int action =0;
        int NewId = 0;
        int count_action;
        System.out.println("--Проверьте правильность введенных данных\n--Если все правильно - введите 1:\n--Если заметили ошибку - введите 2:");
            action = sc.nextInt();

            if (action ==2)
            {
                System.out.println("--Посчитайте количество строк, которые хотите изменить, а затем введите их количество");
                    count_action = sc.nextInt();
                for (int i = 0; i < count_action; i++)
                {
                    System.out.println("--Введите id строки, которую хотите изменить:");
                        NewId = sc.nextInt();
                            data6.setNewId(NewId);
                                data6.NewDeleteIn();
                    sc.nextLine();
                    System.out.println("--Введите номер автобуса:");
                        number = sc.nextLine();
                            data6.setNumber(number);
                    System.out.println("--Введите фамилию и.о. водителя:");
                        name = sc.nextLine();
                                data6.setName(name);
                    data6.NewinsertIn();
                }
                data6.NewgetBusIn();

                System.out.println("--Если готовы приступить к работе - нажмите 1:");
                    System.out.println("--Если заметили ошибки в таблице - нажмите 2:");
                        action = sc.nextInt();
            }

            if (action == 1)
            {
                System.out.println("");
                System.out.println("--Для отправки автобуса в рейс введите 1");
                System.out.println("--Для завершения рабочего дня введите 3");

                int idDep = 0;
                int idArriv = 0;
                int task = 0;
                int CheckExit = 0;
                while (task < 3)
                {
                    task = sc.nextInt();

                    if (task == 3 | task > 3) {}

                        switch (task)
                        {
                            case 1:
                                System.out.println("--Введите id водителя, которого хотите отправить в рейс:");
                                    idDep = sc.nextInt();
                                            data3.setIdDep(idDep);
                                                data3.insertDep();
                                                    data3.DeleteIn();
                                                        data3.getBusDep();
                                                            data3.getBusIn();
                                System.out.println("");
                                    System.out.println("--Для отправки автобуса в рейс введите 1");
                                        System.out.println("--Для въезда автобуса в парк нажмите 2");
                                            System.out.println("--Для завершения рабочего дня введите 3");
                            break;

                            case 2:
                                System.out.println("--Введите id водителя, который завершил рейс:");
                                    idArriv = sc.nextInt();
                                            data4.setIdArriv(idArriv);
                                                data4.insertIn();
                                                    data4.DeleteDep();
                                                        data4.getBusDep();
                                                            data4.getBusIn();
                                System.out.println("");
                                    System.out.println("--Для отправки автобуса в рейс введите 1");
                                        System.out.println("--Для въезда автобуса в парк нажмите 2");
                                            System.out.println("--Для завершения рабочего дня введите 3");
                            break;

                            case 3:
                                System.out.println("--Вы точно хотите завершить рабочий день?");
                                    System.out.println("--Если хотите завершить - нажмите 1\n--Если хотите продолжить - нажмите 2");
                                        CheckExit = sc.nextInt();

                                if (CheckExit == 1)
                                {
                                    System.out.println("--Тяжелый выдался день, не так ли? До новых встреч!");
                                        data5.DeleteTablesIn();
                                            data5.DeleteTableDep();
                                                System.exit(0);
                                }
                                if (CheckExit == 2)
                                {
                                    System.out.println("--Для отправки автобуса в рейс введите 1");
                                        System.out.println("--Для въезда автобуса в парк нажмите 2");
                                            System.out.println("--Для завершения рабочего дня введите 3");
                                }
                        }
                }
            }
    }
}


