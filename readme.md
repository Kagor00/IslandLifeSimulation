    
        В проекті реалізовано симуляцію життя тварин на острові. Запускаючи програму, користувач 
    вводить параметри острова (кількість рядків та стовпців), кількість тварин кожного виду та 
    обирає режим роботи.

        Користувачу запропоновано два режими:
        1. Запуск симуляції на весь період життя популяції. Після завершення симуляції користувач 
    отримає кількість днів, скільки прожила популяція із вказаними параметрами.
        2. Запуск симуляції на фіксовану кількість днів життя популяції. Після завершення симуляції
    користувач отримає статистику популяції (кількість звірів кожного виду) за вказаний період симуляції.

        Після введення параметрів створюються тварини рандомної статі та розміщуються на рандомних 
    клітинках острова, після чого відбувається симуляція їхнього життєвого циклу.

        Всього представлено 15 видів тварин (5 хижаків, 10 травоїдних) та 4 види рослин. В кожної тварини 
    є такі характеристики, як ідентифікатор, стать, вага, насиченість їжею та максимальна швидкість руху
    (максимальна кількість клітинок за хід). В кожної рослини є ідентифікатор та вага. Також, відповідно 
    до поставлених завдань проекту, для кожного виду організмів встановлено обмеження максимальної 
    кількості, яку можна розмістити на одній клітинці.

        Кожна тварина, в процесі життєвого циклу, обирає напрямок руху (рандомно, як по прямій так і по
    діагоналі), переміщується (кількість клітинок рандомна в межах від 1 до рівня максимальної швидкості
    тварини), шукає їжу, з'їдає її відповідно матриці вірогідностей (до ваги додається насиченість, або
    вага з'їденої тварини, якщо вона менша за насиченість), розмножується (шукає пару протилежної статі,
    після чого з'являється нова тварина), та виснажується (від ваги кожного дня віднімається насиченість,
    таким чином тварині постійно потрібно їсти, щоб не померти). Якщо тварина виснажується до нульової
    ваги, вона помирає. Життєвий цикл тварин та ріст рослин відбувається в багатопотоковому середовищі. 
    Кожна клітинка острова працює в окремому потоці.