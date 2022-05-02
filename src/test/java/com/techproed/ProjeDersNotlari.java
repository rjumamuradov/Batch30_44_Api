package com.techproed;

public class ProjeDersNotlari {
    /*
    BATCH44 JİRA DERS NOTLARI 25/02/2022
PROJE OLUŞTURMA
Project -> Create Project
Project Templates -> Software development ->Scrum -> Use Template
Choose a project type: Burada 2 seçenek var.
1) Select a team-managed project: Jirayı yalın halde kullanmak için
2) Select a company-managed project: Ekstra özelliklerini kullanmak için (Raporlama, Xray gibi)
Select a company-managed project’i seçiyoruz.
Name: Proje ismini yazıyoruz. Next’e TIKLIYORUZ.
Go to Project’e TIKLIYORUZ.
PROJEMİZ OLUŞTURULMUŞ OLDU.
PROJEMİZE XRAY’İ EKLEMEMİZ GEREKİYOR.
Apps -> Xray’e TIKLA
Configure Project -> Select the project to configure
kısmından projemizi seçiyoruz. Submit’e TIKLA
Açılan ekranda Add Xray Issue Types’a TIKLA
Test, Precondition, Test Set, Test Execution, Sub Test Execution
Issue Type’ların eklendiğini göreceğiz. Back to project’e TIKLA
ISSUE TYPE
Standart Kurulumda 4 tane issue type var
Story, Epic, Task, Bug
XRay eklentisinden sonra.
Test
Test Set
Test Plan
Test Execution
Precondition
USER STORY VE TEST CASELERİN GİRİLMESİ
Sol menüde Backlog’a TIKLA
Sağ tarafta Create Sprint’e TIKLA
Create -> Issue Type -> Story
Summary -> User story’in ismini yaz.
Description -> Acceptance Criteria’ları yazıyoruz.
Assignee -> Bu User Story kime atanacaksa o seçilir.
Priorty -> Seçilir
Sağ alt köşedeki Creat’e TIKLANIR. User Story oluşturulmuş olur.
(USER STORYLERİN TAMAMINI BU ŞEKİLDE BACKLOG’A EKLEYECEĞİZ)
TEST CASE OLUŞTURMA
1)Issue Type Test seçilir.
2)User Story içindeki kabul kriterleri summary kısmına yazılır.
3)Test Case ilgili User Story’e link edilir.
(BU ADIM ÇOK ÖNEMLİ, TEST CASELER İLGİLİ USERY STORYLERE MUTLAKA LİNK EDİLMELİ)
4)Test Steps oluşturulur
Create -> Issue Type -> Test
Summary -> 1. Acceptance Criteria (1. Test Case) yazılır.
Issue -> User Story’e link edilir.
Assignee -> Bu Test Case kime atanacaksa o seçilir.
Priorty -> Seçilir
Sağ alt köşedeki Creat’e TIKLANIR. Test Case oluşturulmuş olur.
(TEST CASELERİN TAMAMINI BU ŞEKİLDE BACKLOG’A EKLEYECEĞİZ)
OLUŞTURDUĞUMUZ USER STORYLERİ VE TEST CASELERİ, SÜRÜKLEYEREK (DRAG AND DROP)
SPRINT KISMINA AKTARIYORUZ.
SAĞ ÜST KÖŞEDE Start Sprint Aktif oldu. Start Sprint’e TIKLIYORUZ.
Sprint Name: Sprintin ismi yazılır
Duration: Sprintin süresi seçilir. 1 week, 2 weeks, 3 weeks, 4 weeks
Start’a TIKLA
OLUŞTURDUĞUMUZ User Storyler ve Test Caseler TO DO kısmına gelir.
İLK USERY STORY VE TEST CASE IN PROGRESS KISMINA ALINIR.
BÖYLELİKLE USER STORY ÜZERİNDE ÇALIŞMAYA BAŞLAMIŞ OLURUZ.
TEST CASELERİN İÇİNDE STEP OLUŞTURACAĞIZ.
İLK TEST CASE’E ÇİFT TIKLAYIN. ALT TARAFAT Add Step’e TIKLA
Action, Data, Expected Result kısımlarından oluşan Step 1 açılmış oldu.
Buraya Test Case dökümanındaki stepler teker teker girilecek.
Action: Test Case için yapılacak hareket
Data: Gerekli test datası
Expected Result: Beklenen Sonuç
İŞLEMLER GİRİLDİĞİNDE TEST CASE KAPATILIR.
TEST SET OLUŞTURMA
1) Issue Type Test Set seçilir
2) User Story’in tanımı yapılır (US01 Test Set)
3) Aynı User Story’e ait tüm Test Caseler, Test Set’e eklenir.
(USERY STORYDE NE KADAR TEST CASE VARSA TEST SETE LINK EDİLİR.)
Create -> Issue Type -> Test set
Summary -> US01 TEST SET
Issue -> Test Caseler’e link edilir.
Assignee -> Bu Test Set kime atanacaksa o seçilir.
Priorty -> Seçilir
Sprint -> Test Set’in dahil olacağı Sprint seçilir.
Create’e Tıkla. Test Set Sprint’e eklenmiş olur.
To Do dan In progress’e çekilir.
TEST PLAN OLUŞTURMA
1)Issue Type Test Plan seç
2)Tüm testler manasında bir ifade kullan summary
3)Test setler buna eklenir
4)Tüm test caseler buna eklenir
5)Sonra hepsi için execution oluşturulur(run etmeye hazır)
Issue Type -> Test Plan
Summary -> Tüm Testler
TEST PLANI IN PROGRESSE’E AKTAR
TEST PLANA TIKLA
Add tests -> Existing Test
US001'E AİT TESTLER SEÇİLEREK EKLENİR
ÇALIŞTIRILACAK TESTLER EKRANA GELİR. OVERALL EXECUTION STATUS BAŞLIĞIYLA
Create Test Execution -> All Tets -> Create TIKLA
TESTLERİ TEKER TEKER YAP. PASSED’A TIKLA
GERİ DÖNMEK İÇİN EN ÜSTEKİ Return to test Execution
     */

    /*

Murat TANÇ  11:02 PM
AWS HESAP OLUŞTURMA
https://portal.aws.amazon.com/billing/signup#/start
1) Root user email address: email adresinizi girin
2) AWS account name: Hesap isminizi girin
3) Verify email address’e TIKLA
4) Confirm you are you: mail adresinize gelen kodu
“Verification code” kısmına yaz ve Verify’a TIKLA
5) Create your password: Password Olusturm
Root user password:
Confirm root user password:
“Continue (step 1 of 5)“” TIKLA
6) Contact Information
	“Personal - for your own projects” SECA
	Full Name
	Phone Number
	Country or Region
	Address
	City
	State, Province, or Region
	Postal Code
	I have read and agree to the terms of the AWS Customer Agreement. SEÇ
“Continue (step 2 of 5)“” TIKLA
7) Billing Information: ÖDEME KISMI
NOT: Arkadaşlar AWS kredi kartınızdan ülkeden ülkeye değişmekle birlikte 0 dolar doğrulama ücreti kesiyor.
Bazı ülkelerde 1 dolar veya 1 Euro kesiyor. Bilginize.
Credit or Debit card number:
Expiration date:
Cardholder’s name:
“Billing adress -> Use My contact adress” SEÇ
“Verify and Continue (step 3 of 5)“” TIKLA
8) Confirm your identity
	Country or region code
	Mobile phone number
	Security check
Send SMS (step 4 of 5) TIKLA
9) Confirm your identity

	Verify code: Telefona gelen kodu yaz
Continue (step 4 of 5) TIKLA
10) Select a support plan
“Basic support - Free” SEÇ
“Complete sign up” TIKLA
ÜYELİK TAMAMLANDI.
“Go to the AWS Management Console” TIKLA
11) Sign in
Root user email address:
NEXT’e TIKLA
12) Security check
Submit’e TIKLA
13) Password: Şifreni Yaz
	“Sign in” TIKLA
AWS Management Console giriş yapmış oldunuz.
SANAL MAKİNA KURULUMU
EC2 TIKLA
Açılan Sayfada Launch Instances’a TIKLA (Sağ Üst Köse)
1.Choose AMI(Amazon Machine Image)
Ubuntu Server 20.04, 64 Bit, SELECT’e TIKLA
2. Choose Instance Type
Açılan Sayfada t2.micro Free tier eligible olanı SEÇ NEXT
3.Configure Instance Details
Açılan Sayfada hiçbir seçim yapmadan NEXT(Add Storage) TIKLA
4.Add Storage -> Size 16GB yap ve NEXT
5.Add Tags -> Key: Name, Value: JenkinsNew NEXT
6.Congigure Security Group
SSH -> Source ->My Ip SEÇ
Add Rule -> Port Range 8080, Source ->My Ip SEÇ
Add Rule ->Type -> HTTP
Add Rule ->Type -> HTTPS
Review And Lunch’a TIKLA
7.Review -> Launch’a TIKLA
create an existing key pair
rsa seç
keye ism ver
oluştur de keyi bilgisayara yükle
lazım olacak önemli
Your instances are now launching
The following instance launches have been initiated: i-0745d1acffa63c6e1
i-0745d1acffa63c6e1 TIKLA
CONNECT’e TIKLA
EC2 Instance Connect veya SSH Client ile bağlanabiliriz
CMD DE İNDİRDİĞİNİZ KEY DOSYASININI KONUMUNU AÇIN
AWS Console da - Intances - Intances ID TIKLA
Connect - SSH Cliet TIKLA
Connect to your instance using its Public DNS:
Example daki kodu kopyala ve CMD Ekranına yapıştır ENTER
ssh -i “Jenkins.pem” ubuntu@ec2-18-207-180-135.compute-1.amazonaws.com
1)Update and get ready all tools and packages on Ubantu Server
sudo apt-get update
sudo apt-get upgrade
2)INSTALL LATEST CHROME Binary on UBANTU SERVER
sudo apt-get install -y libappindicator1 fonts-liberation
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo dpkg -i google-chrome*.deb
sudo apt-get install -f
sudo dpkg -i google-chrome*.deb
INSTALL LATEST CHROME DRİVER ON UBANTU SERVER
sudo apt install unzip
wget https://chromedriver.storage.googleapis.com/101.0.4951.41/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
sudo mv chromedriver /usr/bin/chromedriver
MAIN TOOL INSTALLATIONS
sudo apt-get install default-jdk
sudo apt install maven
sudo apt install git
JENKINS INSTALATION
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins
Browser’da http://3.139.59.40:8080/	Jenkinse girmiş olduk.
JENKINS KURULUM İÇİN PASSWORD ALMA
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
Kodunu kullanarak kurulum için gereken password aldık
8de50f2644c94765a8fa77a618b9b19c
JENKINS KURULUMU TAMAMLANDI
Manage Jenkins -> Global Tool Configuration
JDK -> Add JDK
Name -> JAVA_HOME
JAVA_HOME -> /usr/lib/jvm/java-11-openjdk-amd64
Git -> Git Path -> /usr/lib/git-core/git
Maven -> Name: MAVEN_HOME
		MAVEN_HOME: /usr/share/maven
APPLY AND SAVE
New Item (Yeni Öğe)
Enter an item name : *******
Freestyle project
OK
Git -> Repository URL
https://github.com/HalilIbrahimHasan/jenkins_cloud.git
Build -> Invoke top-level Maveb target
Maven Version -> MAVEN_HOME
Goals -> clean install
clean test -Dcucumberoptions=“--tags @smoketest”
clean test -P TestRunne
     */
}
