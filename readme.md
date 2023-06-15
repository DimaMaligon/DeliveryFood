# Приложение для заказа еды:
Приложение с помощью которого ты можешь заказать свои любимые блюда.

<p  align="center">
<code><img width="30%" title="main" src="readme_images/images/category_main.png"></code>
</p>

## Стек используемых технологий

<p  align="left">
<code><img width="5%" title="Rxjava" src="readme_images/icons/rxjava.png"></code>
<code><img width="5%" title="Retrofit" src="readme_images/icons/retrofit.png"></code>
<code><img width="5%" title="Git" src="readme_images/icons/github.png"></code>
<code><img width="5%" title="Gradle" src="readme_images/icons/gradle.png"></code>
<code><img width="5%" title="Kotlin" src="readme_images/icons/kotlin.png"></code>
<code><img width="5%" title="MVVM" src="readme_images/icons/mvvm.png"></code>
<code><img width="5%" title="Hilt" src="readme_images/icons/hilt.png"></code>
</p>

##  Описание работы приложения

После загрузки приложения мы видим экран где есть: 
Toolbar, BottomNavigationMenu, список категорий.
Для перехода к списку блюд тапаем на любое изображение категории.

<p align="center">
  <code> <img width="30%" title="Vi" src="readme_images/gif/device-open_category.gif"></code>
</p>

На экране Списка блюд, есть: теги, список еды, верхний Toolbar(содержит уже название группы блюд и 
кнопку для возврата на предыдущий экран.), BottomNavigationMenu. Чтобы  посмотреть 
определенный вид пищи, нужно тапнуть на него.

<p  align="center">
<code><img width="30%" title="dishes" src="readme_images/images/dishes_list.png"></code>
</p>

Если мы хотим добавить блюдо, то тапаем по кнопке ```Добавить в корзину```.

<p align="center">
  <code> <img width="30%" title="Vide" src="readme_images/gif/device-open-dish.gif"></code>
</p>

Для работы с корзиной тапаем в BottomNavigationMenu на item ```Корзина```. Тут мы можем менять 
количество блюд. А если нажать минус, когда количество определенного блюда равно 1, то оно исчезнет
из списка. Также тут есть кнопка для оформления заказа.

<p align="center">
  <code> <img width="30%" title="Video" src="readme_images/gif/device-delete_dish.gif"> </code>
</p>

## Описание проекта

`adapter` - тут классы адаптеры для работы с Recyclerview

`api` - тут классы адаптеры для работы с API

`app` - тут делаем свою реализацию Application для добавления библиотеки dagger2 хилтом

`di` - тут класcы для работы с зависимостями

`fragment` - тут класcы для работы c фрагментами

`fragment_actionbar` - тут класcы для работы c фрагментами, которые содержат actionbar, 
такие фрагменты можно подключить на определенные экраны, где нам нужен данный actionbar.

`fragment_popup` - тут класcы для работы c фрагментами содержащими pop_up. Подключаем, когда нужно
открыть подробную карточку блюда в pop_up.

`view` - тут класcы для работы c ViewModel. С помощью этих классов реализуем архитектуру MVVM и 
работаем с данными в потоках.