## جدول تغییرات گام اول

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
  <tr>
  <th></th>
  <th>کلاس تغییر یافته/اضافه شده</th>
    <th>توضیح کوتاه در مورد تغییر</th>
    <th>------------</th>
    <th>-----------------</th>
    </tr>
  <td>3</td>                                                            
  <td>SMSSender</td>
  <td>کلاسی جهت ارسال پیام SMS</td>
  <td></td>
  <td></td>
  </tr>
</table>

</div>
