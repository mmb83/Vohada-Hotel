<div dir="rtl" align="right">## جدول تغییرات گام اول

<div dir="rtl" align="right">

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
    <td>Message Sender</td>
    <td>افزودن یک تابع برای ارسال پیامک به نام <code>SendSms</code></td>
    <td>Payment Processor</td>
    <td>افزودن یک تابع برای پرداخت حضوری به نام <code>PayOnSite</code></td>
  </tr>
  <tr>
    <td>2</td>
    <td>EmailSender </td>
    <td>پیاده سازی تابع <code>SendSms</code>    (با بدنه خالی)</td>
    <td>Reservation
    Service</td>
    <td>اضافه کردن یک شرط برای انتخاب روش پرداخت حضوری</td>
  </tr>
  
  <td>3</td>                                                            
  <td>SMSSender</td>
  <td>کلاسی جهت ارسال پیام SMS</td>
  <td></td>
  <td></td>
  </tr>
</table>

</div>



## گام دوم (تحلیل اصول شی‌گرایی)

بر اساس تجربه‌ی گام ۱ و با مشورت هم‌گروهی خود، بررسی کنید که در کد اولیه (پیش از تغییر) کدام یک از اصول شی‌گرایی زیر رعایت
و یا نقض شده؟ نتیجه را با ذکر علت در جدول زیر بنویسید (برای پاسخ بهتر، کد داده شده را نیز بررسی کنید).


<div dir="rtl" align="right">

<table border="1" width="100%" style="border-collapse: collapse; text-align:center;">

  <tr>
    <th width="15%">اصل</th>
    <th width="15%">مورد برقراری / نقض</th>
    <th width="20%">کلاس</th>
    <th>علت برقراری / نقض</th>
  </tr>

  <!-- SRP -->
  <tr>
    <td rowspan="2">اصل SRP</td>
    <td>مورد برقراری</td>
    <td>کلاس های موجود در models</td>
    <td>چون تنها یک کار واحد را انجام میدهند</td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td>ReservationService </td>
    <td>به دلیل اینکه کلاس  ReservationService کار های زیادی از جمله چک کردن شهر، نوع پرداخت و نوع ارسال پیام را انجام میدهد و این خلاف این اصل است.</td>
  </tr>

  <!-- OCP -->
  <tr>
    <td rowspan="2">اصل OCP</td>
    <td>مورد برقراری</td>
    <td>Room</td>
    <td>کلاس room  این اصل را برقرار کرده و به راحتی میتوانیم زیر کلاس های مختلف به آن اضافه کنیم.</td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td>MessageSender PaymentProcessor</td>
    <td>در دو کلاس ارسال پیام و نوع پرداخت این اصل نقض شده به این دلیل که برای اضافه کردن یک روش یا گسترش آن نیاز به تغییرات زیادی وجود دارد </td>
  </tr>

  <!-- LSP -->
  <tr>
    <td rowspan="3">اصل LSP</td>
    <td>مورد برقراری</td>
    <td>MessageSender
    Room</td>
    <td>کلاس luxury room  با کلاس room  رابطه is-a  داره.
رابط ارسال پیام در اینجا رابطه  is-a  دارند.
</td>
  </tr>
  <tr>
    <td>مورد نقض ۱</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>مورد نقض ۲</td>
    <td></td>
    <td></td>
  </tr>

  <!-- ISP -->
  <tr>
    <td rowspan="2">اصل ISP</td>
    <td>مورد برقراری</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td></td>
    <td></td>
  </tr>

</table>

<br/><br/>

<table border="1" width="100%" style="border-collapse: collapse; text-align:center;">

  <tr>
    <th width="15%">اصل</th>
    <th width="15%">مورد برقراری / نقض</th>
    <th width="20%">کلاس</th>
    <th>علت برقراری / نقض</th>
  </tr>

  <!-- DIP -->
  <tr>
    <td rowspan="2">اصل DIP</td>
    <td>مورد برقراری</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td></td>
    <td></td>
  </tr>

  <!-- PLK -->
  <tr>
    <td rowspan="2">اصل PLK</td>
    <td>مورد برقراری</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td></td>
    <td></td>
  </tr>

  <!-- CRP -->
  <tr>
    <td rowspan="2">اصل CRP</td>
    <td>مورد برقراری</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>مورد نقض</td>
    <td></td>
    <td></td>
  </tr>

</table>

</div>
