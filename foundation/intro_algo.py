 #!/usr/bin/python
 # -*- coding: utf-8 -*-
import getpass  # hide password
import os
import time  # rest time when notification


status = ""
login = ""

users = dict()

os.system("")  # so ascii color code will work


def file():
    global users
    try:
        with open("user.txt", 'r') as f:
            for line in f:  # read
                # make it into key and val varaible
                (key, val) = line.rstrip("\n").split(":")
                users[str(key)] = val  # input it into users dict
    except:
        with open("user.txt", 'a+') as f:  # a+ is
            for line in f:
                (key, val) = line.rstrip("\n").split(":")
                users[str(key)] = val


def newUser():
    creatingLogin = input("Create username: ")
    global users
    file()
    if creatingLogin in users:
        print('\n\033[91m', "Username already in use!", '\033[0m\n')
    else:
        users[creatingLogin] = getpass.getpass(prompt="Create Password: ")
        print('\033[1m', "User created\n", '\033[0m')
        with open("user.txt", 'w') as f:  # save user list into user.txt
            for key, value in users.items():
                f.write('%s:%s\n' % (key, value))


def oldUser():
    global login
    login = input("Enter username: ")
    # Prompt the user for a password without echoing.
    password = getpass.getpass(prompt="Enter Password: ")

    global users
    file()
    if login in users and users[login] == password:
        print('\033[92m', "Login Successful!", '\033[0m')
        time.sleep(0.3)
        menu_page()
    else:
        print(
            '\033[91m', "\n!!!!Username does not exist or wrong password!!!!\n", '\033[0m')
        time.sleep(0.3)


def start():
    print('\033[0m')  # reset ascii color code
    try:
        global status
        while status != "q" and option != 00:
            status = input(
                "'y' - login\n'n' - register\n'q' - quit\nAre you an existing user? ")
            if status == "y" or status == "n":
                if status == "y":
                    oldUser()
                elif status == "n":
                    newUser()
            elif status != "q":
                print("invalid input\n")
                time.sleep(0.5)
                continue
        print("Quitting Program...")
        print('\033[99m')  # default color
    except:
        # if any force exit causing error occur, will change back to default color
        print('\033[99m')


################################################################################################################################################
'''menu_page'''
################################################################################################################################################
newbook = ['Harry Potter', 'The Lincoln Highway',
           'Promise Me, Dad', 'A Crooked Tree', 'The Wife Upstairs']

missingbooks = []

stocks = []

option = ""
choice = ""


def menu():
    global option

    print("""
  ___           _     _                 _                             _             
 | _ ) ___  ___| |__ (_)_ ___ _____ _ _| |_ ___ _ _ _  _   ____  _ __| |_ ___ _ __  
 | _ \/ _ \/ _ \ / / | | ' \ V / -_) ' \  _/ _ \ '_| || | (_-< || (_-<  _/ -_) '  \ 
 |___/\___/\___/_\_\ |_|_||_\_/\___|_||_\__\___/_|  \_, | /__/\_, /__/\__\___|_|_|_|
                                                    |__/      |__/                  
""", "Hi!", '\033[92m', login, '\033[0m\n', "   -------menu page-------\n", "   [1] Stock Item Records\n", "   [2] Purchase New Book\n",
          "   [3] Add New Books\n", "   [4] Report Missing Book\n", "   [5] logout\n", "\n    [00] Quit Program")
    option = int(input("Enter your option: "))


def stockitems():
    global choice
    print("\n-------Stock Item Record-------\n",
          "[1] Edit Stock\n", "[2] Delete Stock\n", "[00] Back to Main Menu\n")
    choice = int(input("Enter your option: "))


def read_newbooktxt():
    global newbook
    with open("newbook.txt", 'r') as file:
        while (line := file.read().splitlines()):
            newbook = line


def write_newbooktxt():
    with open("newbook.txt", 'w') as f:
        for element in newbook:
            f.write(element + '\n')


def menu_page():
    try:
        clearConsole = lambda: os.system('cls' if os.name in ('nt', 'dos') else 'clear')
        clearConsole()
        global option, newbook, missingbooks, choice
        menu()
        try:
            read_newbooktxt()
        except:
            write_newbooktxt()
        try:
            with open("missingbooks.txt", 'r') as file:
                while (line := file.read().splitlines()):
                    missingbooks = line
        except:
            with open("missingbooks.txt", 'w') as f:
                for element in missingbooks:
                    f.write(element + '\n')
        while option != 00:
            book_num = len(newbook)
            if option == 1:
                stockitems()
                while choice != 00:
                    if choice == 1:
                        read_newbooktxt()
                        # enumerate count the current iteration, so it save one line of code "name = newbook[number]"
                        for number, name in enumerate(newbook, 1):
                            print(
                                f" [{number}]\033[33m {name}\033[0m", end=',')
                        print("\n[00] cancel")
                        f = int(input(
                            "\nEnter the number of arrangement of books you want to delete [1-{}]: ".format(book_num)))
                        while f != 00:
                            if f > 0 and f <= len(newbook):
                                x = input("Enter the new book name: ")
                                if x in newbook:
                                    print(
                                        '\033[91m', "booksname already in use!", '\033[0m')
                                    time.sleep(0.3)
                                    f = 00
                                    continue
                                else:
                                    newbook.pop(f-1)
                                    newbook.insert(f-1, x)
                                    write_newbooktxt()
                                    print("\033[33m", newbook, "\n\033[0m")
                            else:
                                print('\033[91m', "invalid index", '\033[0m')
                                time.sleep(0.3)
                            f = 00
                        stockitems()
                    elif choice == 2:
                        read_newbooktxt()
                        for number, name in enumerate(newbook, 1):
                            print(
                                f" [{number}]\033[33m {name}\033[0m", end=',')
                        print("\n[00] cancel")
                        # formats the specified value and insert them inside the string's placeholder.
                        f = int(input(
                            "\nEnter the number of arrangement of books you want to delete [1-{}]: ".format(len(newbook))))
                        while f != 00:
                            if f > 0 and f <= book_num:
                                newbook.pop(f-1)
                                write_newbooktxt()
                                print("\033[33m", newbook, "\n\033[0m")
                            else:
                                print('\033[91m', "invalid index", '\033[0m')
                                time.sleep(0.3)
                            f = 00
                        stockitems()
                    else:
                        print('\033[91m', "invalid index"'\033[0m')
                menu()

            elif option == 2:
                x = int(
                    input("[1]Amazon\n[2]popular\n\n[00]back\nSelect store[1-2]: "))
                print("\033[33m""https://www.amazon.com/books-used-books-textbooks/b?ie=UTF8&node=283155\n", "\033[0m") if x == 1 else (print("\033[33m", "https://www.popularonline.com.my/\n""\033[0m")
                                                                                                                                        if x == 2 else (menu()if x == 00 else print('\033[91m', "Invalid index\n", '\033[0m'), time.sleep(0.3)))

            elif option == 3:
                for number, name in enumerate(newbook, 1):
                    print(f" [{number}]\033[33m {name}\033[0m", end=',')
                print("\n[00] cancel")
                x = input("\nEnter name of the new book: ")
                while x != "00":
                    if x in newbook:
                        print('\033[91m',
                              "booksname already in use!", '\033[0m\n')
                        time.sleep(0.3)
                    else:
                        newbook.append(x)
                        print("Books Available: ",
                              "\033[33m", newbook, "\033[0m")
                        write_newbooktxt()
                    x = "00"
                menu()

            elif option == 4:
                print("\nBooks to be found: ",
                      "\033[33m", missingbooks, "\033[0m")
                z = int(input(
                    "   [1]add missingbook\n   [2]found missingbook\n\n   [00]back\nEnter your option: "))
                while z != 00:
                    if z == 1:
                        read_newbooktxt()
                        delete = list(set(newbook).intersection(missingbooks))
                        newbookk = newbook.copy()
                        for i in range(len(delete)):
                            newbookk.remove(delete[int(i)])
                        print("\n")
                        for number, name in enumerate(newbookk, 1):
                            print(
                                f" [{number}]\033[33m {name}\033[0m", end=',')
                        print("\n[00] cancel")
                        f = int(input(
                            "Enter the number of arrangement of books that is missing [1-{}]: ".format(len(newbookk))))
                        while f != 00:
                            if f > 0 and f <= book_num:
                                missingbooks.append(newbookk[f-1])
                                with open("missingbooks.txt", 'w') as f:
                                    for element in missingbooks:
                                        f.write(element + '\n')
                                print("Books to be found: \033[33m",
                                      missingbooks, "\n\033[0m")
                            else:
                                print(
                                    '\033[91m', "integer should between the range", '\033[0m\n')
                                time.sleep(0.3)
                            f = 00
                        z = int(input(
                            "   [1]add missingbook\n   [2]found missingbook\n\n   [00]back\nEnter your option: "))
                    elif z == 2:
                        read_newbooktxt()
                        if len(missingbooks) == 0:
                            print("no missing book!\n")
                            time.sleep(0.3)
                            z = int(input(
                                "   [1]add missingbook\n   [2]found missingbook\n\n   [00]back\nEnter your option: "))
                            continue
                        for number, name in enumerate(missingbooks, 1):
                            print(
                                f" [{number}]\033[33m {name}\033[0m", end=',')
                        print("\n[00] cancel")
                        f = int(input(
                            "Enter the number of arrangement of books that is found [1-{}]: ".format(len(missingbooks))))
                        while f != 00:
                            if f > 0 and f <= book_num:
                                try:
                                    missingbooks.remove(missingbooks[f-1])
                                except TypeError as e:
                                    print(e)
                                with open("missingbooks.txt", 'w') as f:
                                    for element in missingbooks:
                                        f.write(element + '\n')
                                    print("Books to be found: \033[33m",
                                          missingbooks, "\n\033[0m")
                            elif f < 0 or f > book_num:
                                print(
                                    '\033[91m', "integer should between the range", '\033[0m\n')
                                time.sleep(0.3)
                            f = 00
                        z = int(input(
                            "   [1]add missingbook\n   [2]found missingbook\n\n   [00]back\nEnter your option: "))
                    else:
                        print("\033[91m""invalid index", "\033[0m")
                        z = int(input(
                            "   [1]add missingbook\n   [2]found missingbook\n\n   [00]back\nEnter your option: "))
                menu()

            elif option == 5:
                print('\033[92m', "logout Successful!\n", '\033[0m')
                time.sleep(0.3)
                start()
                exit()
            else:
                print('\033[91m', "invalid option", '\033[0m')
                time.sleep(0.3)
                menu()

        print("Quitting Program...", '\033[99m')
        exit()

    except TypeError:
        print('\033[91m', "Input should be a number!", '\033[0m')
        time.sleep(0.3)
        menu_page()
    except ValueError:
        print('\033[91m', "Input should be a integer!!", '\033[0m')
        time.sleep(0.3)

        menu_page()
    except IndexError:
        print("Input a number before starting!")
        print('\033[0m')
        time.sleep(0.3)
        menu_page()


if __name__ == '__main__':

    start()
