import java.sql.SQLException;
import java.util.Scanner;

public class Actions
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
    int NewId = 0;
    int count_action = 0;
    int idDep = 0;
    int idArriv = 0;
    int task = 0;
    int CheckExit = 0;
    int check = 0;
    int count_correction = 2;
    int delete_row = 0;
    int checkChose = 0;

    public void introduction() throws SQLException, ClassNotFoundException
    {
        for (int a = 0; a < count_attempt; a++)
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
            if (a == 2)
            {
                System.out.println("--Вы превысили количество допустимых попыток");
                    System.exit(0);
            }
        }
        data2.getBusIn();
    }

    public void correction() throws SQLException, ClassNotFoundException
    {
        System.out.println("--//Вам доступно всего 2 попытки редактирования//--");
            for (int y = 0; y<count_correction; y++)
            {
                    System.out.println("--Посчитайте количество строк, которые хотите изменить, а затем введите их количество");
                        System.out.println("--Если хотите выйти из функции внесения изменений - нажмите 777");
                            count_action = sc.nextInt();
                if (count_action == 777)
                {
                    break;
                }
                if (count_action <= count_bus & count_action > 0)
                {
                    for (int i = 0; i < count_action; i++)
                    {
                        System.out.println("--Если хотите полностью удалить строчку - нажмите 1");
                            System.out.println("--Если хотите внести точечные изменения - нажмите 2");
                                System.out.println("--Если хотите выйти из функции внесения изменений - нажмите 777");
                                    delete_row = sc.nextInt();
                        if (delete_row == 1)
                        {
                            System.out.println("--Введите id строки, которую хотите удалить");
                                NewId = sc.nextInt();
                                    data6.setNewId(NewId);
                                        data6.NewDeleteIn();
                            if (NewId <=0 & NewId > count_bus)
                            {
                                System.out.println("--Вы ввели недопустимое число");
                            }
                        }
                        if (delete_row == 2)
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

                            if (NewId <=0 & NewId > count_bus)
                            {
                                System.out.println("--Вы ввели недопустимое число");
                            }
                        }
                        if (delete_row == 777)
                        {break;}
                    }
                    data6.NewgetBusIn();
                }
                else
                {
                    System.out.println("-!-!-ERROR: вы ввели недопустимое число (Повторите попытку еще раз)\n");
                }
            }
    }

    public void work() throws SQLException, ClassNotFoundException
    {
        System.out.println("");
            System.out.println("--Для отправки автобуса в рейс введите 1");
                System.out.println("--Для завершения рабочего дня введите 3");
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
                                    task = sc.nextInt();
                    }
                    break;
            }
        }
    }

    public void CorrectionInDB() throws SQLException, ClassNotFoundException
    {
        for (int c = 0; c < count_correction; c++)
        {
            System.out.println("--Если хотите внести изменения - нажмите 1\n--Если готовы начать работу - нажмите 2");
                System.out.println("--//Во время работы вы не сможете изменить таблицу//--");
                    check = sc.nextInt();
            if (check == 1)
            {
                System.out.println("--Если случайно нажали 1 - нажмите 2\n--Если хотите приступить к редактированию - нажмите 1");
                    checkChose = sc.nextInt();
                        if (checkChose == 1)
                        {
                            correction();
                        }
                        if (checkChose == 2)
                        {}
                        break;
            }

            if (check == 2)
            {
                System.out.println("--Если случайно нажали 2 - нажмите 1\n--Если хотите приступить к работе - нажмите 2");
                    checkChose = sc.nextInt();
                        if (checkChose == 1)
                        {
                            correction();
                        }
                        if (checkChose == 2)
                        {}
                        break;
            }
        }
    }
}
