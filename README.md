<div dir="rtl" align="right">

# پروژه سیستم رزرواسیون هتل - تحلیل اصول شی‌گرایی

## فهرست مطالب
- [گام اول: جدول تغییرات](#گام-اول-جدول-تغییرات)
- [گام دوم: تحلیل اصول شی‌گرایی](#گام-دوم-تحلیل-اصول-شیگرایی)
  - [اصل SRP](#اصل-srp)
  - [اصل OCP](#اصل-ocp)
  - [اصل LSP](#اصل-lsp)
  - [اصل ISP](#اصل-isp)
  - [اصل DIP](#اصل-dip)
  - [اصل PLK](#اصل-plk)
  - [اصل CRP](#اصل-crp)

## گام اول: جدول تغییرات

### جدول تغییرات گام اول

<table>
  <tr>
    <th rowspan="2">ردیف</th>
    <th colspan="2">تغییرات مربوط به افزودن روش جدید ارسال پیام</th>
    <th colspan="2">تغییرات مربوط به افزودن روش جدید پرداخت</th>
  </tr>
  <tr>
    <th>کلاس تغییر یافته/اضافه شده</th>
    <th>توضیح کوتاه در مورد تغییر</th>
    <th>کلاس تغییر یافته</th>
    <th>توضیح کوتاه در مورد تغییر</th>
  </tr>
  <tr>
    <td>1</td>
    <td>MessageSender</td>
    <td>افزودن یک تابع برای ارسال پیامک به نام <code>SendSms</code></td>
    <td>PaymentProcessor</td>
    <td>افزودن یک تابع برای پرداخت حضوری به نام <code>PayOnSite</code></td>
  </tr>
  <tr>
    <td>2</td>
    <td>EmailSender</td>
    <td>پیاده‌سازی تابع <code>SendSms</code> (با بدنه خالی)</td>
    <td>ReservationService</td>
    <td>اضافه کردن یک شرط برای انتخاب روش پرداخت حضوری</td>
  </tr>
  <tr>
    <td>3</td>
    <td>SMSSender</td>
    <td>کلاسی جهت ارسال پیام SMS</td>
    <td></td>
    <td></td>
  </tr>
</table>

## گام دوم: تحلیل اصول شی‌گرایی

بر اساس تجربه‌ی گام ۱ و با مشورت هم‌گروهی خود، بررسی شده است که در کد اولیه (پیش از تغییر) کدام یک از اصول شی‌گرایی زیر رعایت یا نقض شده است.

### تحلیل جامع اصول SOLID و سایر اصول

<table border="1" width="100%" style="border-collapse: collapse; text-align:center;">
  <tr>
    <th width="15%">اصل</th>
    <th width="15%">وضعیت</th>
    <th width="20%">کلاس/رابط مرتبط</th>
    <th>توضیح و تحلیل</th>
  </tr>

  <!-- SRP -->
  <tr>
    <td rowspan="2">اصل SRP<br>(Single Responsibility Principle)</td>
    <td>✅ برقراری</td>
    <td>کلاس‌های موجود در پکیج models</td>
    <td>تمامی کلاس‌های موجود در پکیج models (مانند Customer، Reservation، Room) تنها یک مسئولیت واحد دارند و یک کار مشخص را انجام می‌دهند.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>ReservationService</td>
    <td>کلاس ReservationService دارای مسئولیت‌های متعددی از جمله بررسی شهر مشتری، مدیریت نوع پرداخت، انتخاب روش ارسال پیام و پردازش رزرو است که این امر نقض اصل تک‌مسئولیتی محسوب می‌شود.</td>
  </tr>

  <!-- OCP -->
  <tr>
    <td rowspan="2">اصل OCP<br>(Open/Closed Principle)</td>
    <td>✅ برقراری</td>
    <td>کلاس Room</td>
    <td>کلاس Room به‌خوبی این اصل را رعایت کرده است. به‌راحتی می‌توان زیرکلاس‌های مختلفی مانند LuxuryRoom، StandardRoom و غیره را بدون تغییر در کد موجود اضافه کرد.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>MessageSender<br>PaymentProcessor</td>
    <td>در دو رابط MessageSender و PaymentProcessor این اصل نقض شده است. برای اضافه کردن یک روش جدید ارسال پیام یا پرداخت، نیاز به تغییر مستقیم در رابط اصلی و در نتیجه تغییر در تمام کلاس‌های پیاده‌ساز آن داریم.</td>
  </tr>

  <!-- LSP -->
  <tr>
    <td rowspan="3">اصل LSP<br>(Liskov Substitution Principle)</td>
    <td>✅ برقراری</td>
    <td>کلاس‌های Room و LuxuryRoom</td>
    <td>کلاس LuxuryRoom رابطه is-a با کلاس Room دارد و می‌توان در هر جایی که از Room استفاده می‌شود، از LuxuryRoom نیز استفاده کرد بدون آن‌که رفتار برنامه تغییر کند.</td>
  </tr>
  <tr>
    <td>✅ برقراری</td>
    <td>رابط MessageSender و پیاده‌سازهای آن</td>
    <td>رابط‌های ارسال پیام نیز رابطه is-a را به‌درستی برقرار کرده‌اند.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>EmailSender و SMSSender</td>
    <td>پیاده‌سازی ناقص متدها (مانند sendSms در EmailSender با بدنه خالی) باعث می‌شود نتوان به‌درستی از هر زیرکلاس به‌جای والد استفاده کرد و این نقض اصل جایگزینی لیسکوف است.</td>
  </tr>

  <!-- ISP -->
  <tr>
    <td rowspan="2">اصل ISP<br>(Interface Segregation Principle)</td>
    <td>✅ برقراری</td>
    <td>-</td>
    <td>در طراحی فعلی مورد برقراری خاصی مشاهده نشده است.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>رابط MessageSender</td>
    <td>رابط MessageSender دارای متدهایی برای ارسال انواع مختلف پیام‌ها (sendSms، sendEmail و ...) است. در نتیجه کلاس‌هایی مانند EmailMessageService مجبور به پیاده‌سازی متد sendSmsMessage با بدنه خالی می‌شوند. هر سرویس باید یک رابط خاص‌تر (مانند SmsService، EmailService) را پیاده‌سازی کند.</td>
  </tr>

</table>

<br/>

<table border="1" width="100%" style="border-collapse: collapse; text-align:center;">
  <tr>
    <th width="15%">اصل</th>
    <th width="15%">وضعیت</th>
    <th width="20%">کلاس/رابط مرتبط</th>
    <th>توضیح و تحلیل</th>
  </tr>

  <!-- DIP -->
  <tr>
    <td rowspan="2">اصل DIP<br>(Dependency Inversion Principle)</td>
    <td>✅ برقراری</td>
    <td>-</td>
    <td>در طراحی فعلی مورد برقراری خاصی مشاهده نشده است.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>ReservationService<br>کلاس Main</td>
    <td>در ReservationService به‌صورت مستقیم نمونه‌هایی از کلاس‌های خاص مانند SmsMessageService و EmailMessageService ساخته می‌شود. همچنین کلاس Main مستقیماً نمونه‌هایی از این کلاس‌ها می‌سازد که نقض DIP محسوب می‌شود. ماژول‌های سطح بالا باید به انتزاع‌ها (Abstract) وابسته باشند، نه به جزئیات پیاده‌سازی.</td>
  </tr>

  <!-- PLK -->
  <tr>
    <td rowspan="2">اصل PLK<br>(Principle of Least Knowledge)<br>(Law of Demeter)</td>
    <td>✅ برقراری</td>
    <td>-</td>
    <td>در طراحی فعلی مورد برقراری خاصی مشاهده نشده است.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>ReservationService</td>
    <td>در کلاس ReservationService اطلاعات زیادی از کلاس‌های دیگر در دسترس است و از زنجیره‌های طولانی استفاده می‌شود. به عنوان مثال، برای رسیدن به نام مشتری از کلاس Reservation به کلاس Customer و سپس به نام مشتری دسترسی مستقیم داریم: <code>reservation.getCustomer().getName()</code> که نقض اصل کمترین آشنایی است.</td>
  </tr>

  <!-- CRP -->
  <tr>
    <td rowspan="2">اصل CRP<br>(Composite Reuse Principle)</td>
    <td>✅ برقراری</td>
    <td>-</td>
    <td>در طراحی فعلی مورد برقراری خاصی مشاهده نشده است.</td>
  </tr>
  <tr>
    <td>❌ نقض شده</td>
    <td>کلاس LuxuryRoom و Room</td>
    <td>کلاس LuxuryRoom از طریق وراثت از کلاس Room گسترش یافته است، در حالی که می‌توانست از طریق ترکیب (Composition) ویژگی‌های اضافی را به دست آورد. این رویکرد باعث وابستگی شدید و شکنندگی می‌شود.</td>
  </tr>

</table>


</div>

گام چهارم : 
---------------------------------------------------------------------------------------------------------------
کلاس PaymentProcessor:یک متغیر جدید از نوع PaymentMethods تعریف میکنیم که مشخص کننده نوع پرداخت است و به جای وجود چند تابع برای هر روش پرداخت , یک تابع pay تعریف میکنیم که متغیر PaymentMethods در بدنه این تابع حضور دارد.

یک کلاس جدید به نام CheckMethod ساختیم که یک متغیر notifier دارد و یک تابع type که یک آبجکت MessageSender برمیگرداند و بسته notifier اینکه از چه زیرکلاسی باشد مشخص میشود.

در کلاس CityDiscount: تابع CheckCityDiscount باید یک double برگرداند , همچنین در حالتی که customer.getCity().equals("Paris") درست نباشد باید مقدا ر 1 را برگرداند.

در کلاس ReservationService: به جای اینکه چک کنیم متغیر notifier چیست و براساس آن یک آبجکت بسازیم,این کار را به کلاس CheckMethod میسپاریم تا اصل SRP برقرار باشد. 


گام پنجم :
---------------------------------------------------------------------------------------------------------------
اگر از همان اول این موارد رعایت می‌شد برای اضافه کردن کلاس ها و یا حتی فیچر های جدید نیاز به تغییرات زیادی نداشتیم و همینطور قابلیت خواندن آن برای فردی که منطق کد را نمیداند راحت تر است.