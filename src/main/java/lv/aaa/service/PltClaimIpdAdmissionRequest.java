/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */

package lv.aaa.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author saas-generator
 */
@NoArgsConstructor
@Data
public class PltClaimIpdAdmissionRequest {

    /**
     * ZA生成 交易编号
     */
    @JsonProperty("TransactionNo")

    private String transactionNo;

    /**
     * 保险编号
     */
    @JsonProperty("ReserveNo")

    private String reserveNo;

    /**
     * 上次治疗日期
     */
    @JsonProperty("PreviousTreatmentDate")

    private String previousTreatmentDate;

    /**
     * 上次治疗细节描述
     */
    @JsonProperty("PreviousTreatmentDetail")

    private String previousTreatmentDetail;

    /**
     * 手术后估计恢复时间(如果病人做了手术)
     */
    @JsonProperty("ExpectedDayOfRecovery")

    private String expectedDayOfRecovery;

    /**
     * 预计出院日期
     */
    @JsonProperty("DscDateTime")

    private String dscDateTime;

    /**
     * 估计住院天数
     */
    @JsonProperty("ExpectedLos")

    private String expectedLos;

    /**
     * 诊断结果
     */
    @JsonProperty("DxFreeText")

    private String dxFreeText;

    /**
     * 身体检查详情
     */
    @JsonProperty("PhysicalExam")

    private String physicalExam;

    /**
     * 治疗计划
     */
    @JsonProperty("PlanOfTreatment")

    private String planOfTreatment;

    /**
     * 入院指示
     * 1 = “Unstable Basic Life Function”   “基本生命功能不稳定”
     * 2 = “Unstable Major Organ Function”   “主要器官功能不稳定”
     * 3 = “High Risk Condition”   “高风险条件”
     * 4 = “Sepsis or rule out sepsis”   “败血症或排除败血症”
     * 5 = “Require Full Nursing Care Facility”   “需要全套护理设施”
     * 6 = “Require Inpatient Surgery”   “需要住院手术”
     * 7 = “Patient of Relatives Request”   “亲属患者请求”
     * 8 = “Other,Please Specify”   “其他，请说明”
     */
    @JsonProperty("IndicationForAdmission")

    private String indicationForAdmission;

    @JsonProperty("IndicationForAdmissionDesc")

    private String indicationForAdmissionDesc;

    //    病人的姓名
    @JsonProperty("Title")

    private String title;

    //    病人的名
    @JsonProperty("FirstName")

    private String firstName;

    //    病人的姓
    @JsonProperty("LastName")

    private String lastName;

    //    病人的姓氏，出生日期
    @JsonProperty("Dob")

    private String dob;

    //    患者性别
    @JsonProperty("Gender")

    private String gender;

    //    医院编码
    @JsonProperty("Hn")

    private String hn;

    //    入院号
    @JsonProperty("AnOrVn")

    private String anOrVn;

    //    入院时间
    @JsonProperty("AdmissionTime")

    private String admissionTime;

    //摩托车意外(是/否)
    @JsonProperty("ClaimFromMotorcycle")

    private String claimFromMotorcycle;

    //    病人在到达医院前是否饮酒或成瘾?(Y/N)(如发生意外)
    @JsonProperty("AlcoholOrDrugYesOrNo")

    private String alcoholOrDrugYesOrNo;

    //    如果病人在到达医院之前已经饮酒或成瘾，需要更多的解释吗?(Y/N)(如发生意外)
    @JsonProperty("AlcoholOrDrugDescription")

    private String alcoholOrDrugDescription;

    //    是程序?(Y = Procedure, N = No Procedure)
    @JsonProperty("IsProcedure")

    private String isProcedure;

    //    重要的症状
    @JsonProperty("CheifComplain")

    private String cheifComplain;

    //    额外注意的
    @JsonProperty("AdditionNote")

    private String additionNote;

    //    ICD10基础疾病代码
    @JsonProperty("UnderlyingDiseasesIcd10")

    private String underlyingDiseasesIcd10;

    //    基础疾病描述
    @JsonProperty("UnderlyingDiseasesDescription")

    private String underlyingDiseasesDescription;

    /**
     * 调查信息
     */
    @JsonProperty("Investigation")

    private List<InvestigationDTO> investigation;

    /**
     * 生命体征信息
     */
    @JsonProperty("VitalSign")

    private List<VitalSignDTO> vitalSign;

    /**
     * 医生信息
     */
    @JsonProperty("Doctor")

    private List<DoctorDTO> doctor;

    /**
     * 文档信息
     */
    @JsonProperty("AttachDocList")

    private List<AttachDocListDTO> attachDocList;

    /**
     * 手术信息
     */
    @JsonProperty("Procedure")

    private List<ProcedureDTO> procedure;

    /**
     * 受益信息
     */
    @JsonProperty("Benefit")

    private List<BenefitDTO> benefit;

    @NoArgsConstructor
    @Data
    public static class InvestigationDTO {

        /**
         * 医院实验室代码
         */
        @JsonProperty("InvestigationCode")

        private String investigationCode;

        /**
         * 调查组
         */
        @JsonProperty("InvestigationGroup")

        private String investigationGroup;

        /**
         * 调查名称
         */
        @JsonProperty("InvestigationName")

        private String investigationName;

        /**
         * 调查结果
         */
        @JsonProperty("InvestigationResult")

        private String investigationResult;

        /**
         * 调查结果日期
         */
        @JsonProperty("InvestigationResultDatetime")

        private String investigationResultDatetime;

        /**
         * 如果发生事故，格拉斯哥昏迷评分3-15分要求的意识水平
         */
        @JsonProperty("ComaScore")

        private String comaScore;

        /**
         * 疾病与酒精有关吗?(Y / N)
         */
        @JsonProperty("AlcoholRelated")

        private String alcoholRelated;

        /**
         * 更多关于酒精相关疾病的解释(确定X毫克%)
         */
        @JsonProperty("AlcoholRelatedDescription")

        private String alcoholRelatedDescription;

        /**
         * 疾病与成瘾有关吗?(Y / N)
         */
        @JsonProperty("AddictionRelated")

        private String addictionRelated;

        /**
         * 更多关于成瘾相关疾病的解释
         */
        @JsonProperty("AddictionRelatedDescription")

        private String addictionRelatedDescription;

        /**
         * 疾病与药物滥用有关吗?(Y / N)
         */
        @JsonProperty("DrugAbuseRelated")

        private String drugAbuseRelated;

        /**
         * 更多关于药物滥用相关疾病的解释
         */
        @JsonProperty("DrugAbuseRelatedDescription")

        private String drugAbuseRelatedDescription;

        /**
         * 疾病与怀孕有关吗?
         */
        @JsonProperty("Pregnancy")

        private String pregnancy;

        /**
         * 疾病与分娩有关吗?
         */
        @JsonProperty("Childbirth")

        private String childbirth;

        /**
         * 疾病与不孕有关吗?
         */
        @JsonProperty("Infertility")

        private String infertility;

        /**
         * 疾病与剖腹产有关吗?
         */
        @JsonProperty("CaesareanSection")

        private String caesareanSection;

        /**
         * 疾病与流产有关吗?
         */
        @JsonProperty("Miscarriage")

        private String miscarriage;

        /**
         * 疾病与紧张有关吗?
         */
        @JsonProperty("Nervous")

        private String nervous;

        /**
         * 疾病与精神有关吗?
         */
        @JsonProperty("Mental")

        private String mental;

        /**
         * 疾病与情绪有关吗?
         */
        @JsonProperty("Emotional")

        private String emotional;

        /**
         * 疾病与睡眠障碍有关吗?
         */
        @JsonProperty("SleepingDisorder")

        private String sleepingDisorder;

        /**
         * 疾病和美容有关吗?
         */
        @JsonProperty("CosmeticReason")

        private String cosmeticReason;

        /**
         * 疾病与牙科护理有关吗?
         */
        @JsonProperty("DentalCare")

        private String dentalCare;

        /**
         * 疾病与屈光不正矫正有关?
         */
        @JsonProperty("RefractiveErrorsCorrection")

        private String refractiveErrorsCorrection;

        /**
         * 疾病与先天有关吗?
         */
        @JsonProperty("Congenital")

        private String congenital;

        /**
         * 疾病与遗传性疾病有关吗?
         */
        @JsonProperty("HereditaryDisease")

        private String hereditaryDisease;

        /**
         * 疾病与HIV有关吗?(Y / N)
         */
        @JsonProperty("AIDS")

        private String aids;

        /**
         * 疾病与身体缺陷有关吗?
         */
        @JsonProperty("PhysicalDefects")

        private String physicalDefects;

        /**
         * 疾病是否与退行性改变有关?
         */
        @JsonProperty("DegenerativeChange")

        private String degenerativeChange;

        /**
         * 疾病与HIV有关吗?
         */
        @JsonProperty("HivTest")

        private String hivTest;

        /**
         * 0 = Negetive
         * 1 = Positive
         * require when hiv_test = Y
         * <p>
         * HIV检测结果
         * 0=负
         * 1=正
         */
        @JsonProperty("HivTestresult")

        private String hivTestResult;

        /**
         * require when hiv_test = Y
         * 艾滋病毒检测日期
         */
        @JsonProperty("HivTestDate")

        private String hivTestDate;

        /**
         * 实验室、心电图、x光片等检查结果
         */
        @JsonProperty("InvestigationAndResult")

        private String investigationAndResult;

        /**
         * 病理报告
         */
        @JsonProperty("PathologicalReport")

        private String pathologicalReport;

        /**
         * ICD10原理诊断代码（主）（1个以上以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("PrincipleDiagnosisCode")

        private List<String> principleDiagnosisCode;

        /**
         * 原理诊断说明（主）（1个以上以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("PrincipleDiagnosisDescription")

        private List<String> principleDiagnosisDescription;

        /**
         * ICD10原理诊断代码（次要）（多于1个以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("SecondDiagnosisCode")

        private List<String> secondDiagnosisCode;

        /**
         * 原理诊断说明（次要）（多于1个以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("SecondDiagnosisDescription")

        private List<String> secondDiagnosisDescription;

        /**
         * ICD10共病诊断代码（1个以上以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("ComorbidityCode")

        private List<String> comorbidityCode;

        /**
         * 共病诊断描述（多于1个以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("ComorbidityDescription")

        private List<String> comorbidityDescription;

        /**
         * ICD10并发症代码（超过1个以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("ComplicationCode")

        private List<String> complicationCode;

        /**
         * 并发症描述（1个以上以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("ComplicationDescription")

        private List<String> complicationDescription;

        /**
         * 其他诊断的ICD10代码（多于1个以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("OtherCodeICD10")

        private List<String> otherCodeICD10;

        /**
         * 其他诊断说明（1个以上以“，”分隔）
         * -如果是非ICD10代码，请使用“-”
         * -最多5次诊断
         */
        @JsonProperty("OtherCodeICD10Description")

        private List<String> otherCodeICD10Description;

    }

    @NoArgsConstructor
    @Data
    public static class VitalSignDTO {

        /**
         * 舒张压
         */
        @JsonProperty("DiastolicBp")

        private String diastolicBp;

        /**
         * 收缩压
         */
        @JsonProperty("SystolicBp")

        private String systolicBp;

        /**
         * 心率
         */
        @JsonProperty("HeartRate")

        private String heartRate;

        /**
         * 血氧饱和度
         */
        @JsonProperty("OxygenSaturation")

        private String oxygenSaturation;

        /**
         * 疼痛评分
         */
        @JsonProperty("PainScore")

        private String painScore;

        /**
         * 呼吸速率
         */
        @JsonProperty("RespiratoryRate")

        private String respiratoryRate;

        /**
         * 体温
         */
        @JsonProperty("Temperature")

        private String temperature;

        /**
         * 进入生命体征的日期和时间
         */
        @JsonProperty("VitalSignEntryDatetime")

        private String vitalSignEntryDatetime;

    }

    @NoArgsConstructor
    @Data
    public static class DoctorDTO {

        /**
         * 医生执照
         */
        @JsonProperty("License")

        private String license;

        /**
         * 医生签字日期
         */
        @JsonProperty("DoctorSignedDate")

        private String doctorSignedDate;

        /**
         * Role status (defult = OWNER)  角色状态（defult=OWNER）
         * OWNER = Doctor of patient  患者医生
         * ADM = Doctor for admit  入院医生
         * DSC = Doctor for discharge  出院医生
         * CONSULT = Doctor for consult  会诊医生
         * SURGEON = Doctor for surgery  外科医生
         * ASST = Assistanct doctor for surgery  外科助理医生
         * ANES = ฤnesthetist  ฤ内斯特派
         * OTHER = Other doctor  其他医生
         */
        @JsonProperty("Role")

        private String role;

        /**
         * 医生的 Title Name
         */
        @JsonProperty("Title")

        private String title;

        /**
         * 医生的名字
         */
        @JsonProperty("Firstname")

        private String firstname;

        /**
         * 医生的姓氏
         */
        @JsonProperty("Lastname")

        private String lastname;

    }

    @NoArgsConstructor
    @Data
    public static class AttachDocListDTO {

        /**
         * 通过base64Data编码的文档
         */
        @JsonProperty("Base64Data")

        private String base64Data;

        /**
         * 文档名称
         */
        @JsonProperty("DocName")

        private String docName;

    }

    @NoArgsConstructor
    @Data
    public static class ProcedureDTO {

        /**
         * ICD9手术代码
         */
        @JsonProperty("Icd9")

        private String icd9;

        /**
         * require when procedure.icd9 = Y
         * 手术日期
         */
        @JsonProperty("ProcedureDate")

        private String procedureDate;

        /**
         * Type of anaesthesia  麻醉类型
         * 1 = General  常规
         * 2 = Spinal   脊柱
         * 3 = Local    本地
         * 4 = Others   其他
         */
        @JsonProperty("AnaesthesiaType")

        private String anaesthesiaType;

        /**
         * 麻醉其他描述（只针对4=Others）
         */
        @JsonProperty("AnsesthesiaOtherDescription")

        private String ansesthesiaOtherDescription;

    }

    @NoArgsConstructor
    @Data
    public static class BenefitDTO {

        /**
         * 医疗费用(SIMB)
         */
        @JsonProperty("SIMBCode")

        private String simbCode;

        /**
         * 医疗费用的描述
         */
        @JsonProperty("SIMBDesc")

        private String simbDesc;

        /**
         * 折扣前账单金额
         */
        @JsonProperty("BillAmountBFDiscount")

        private String billAmountBfDiscount;

        /**
         * 账单折扣金额（便宜了多少钱）
         */
        @JsonProperty("BillDiscountAmount")

        private String billDiscountAmount;

        /**
         * 打折后账单金额
         * billAmountBFDiscount - billDiscountAmount = billAmountAFDiscount
         */
        @JsonProperty("BillAmountAFDiscount")

        private String billAmountAfDiscount;

        /**
         * “SIMB2005”-适用于旧SIMB
         * “SIMB2018”-用于新SIMB
         */
        @JsonProperty("SIMBType")

        private String simbType;

        /**
         * 订单项信息
         */
        @JsonProperty("OrderItem")

        private List<OrderItemDTO> orderItem;

        @NoArgsConstructor
        @Data
        public static class OrderItemDTO {

            /**
             * 订单项编号
             */
            @JsonProperty("OrderItemCode")

            private String orderItemCode;

            /**
             * 订单项描述
             */
            @JsonProperty("OrderItemDescription")

            private String orderItemDescription;

            /**
             * 订单项数量
             */
            @JsonProperty("OrderItemQTY")

            private String orderItemQTY;

            /**
             * 单位订单项价格
             */
            @JsonProperty("OrderPricePerUnit")

            private String orderPricePerUnit;

            /**
             * 用药频率
             */
            @JsonProperty("MedicineFrequency")

            private String medicineFrequency;

            /**
             * 订单项折扣前金额
             */
            @JsonProperty("BillingAmountBFDiscountOrderItem")

            private String billingAmountBfDiscountOrderItem;

            /**
             * 订单项折扣金额
             */
            @JsonProperty("BillingDiscountAmountOrderItem")

            private String billingDiscountAmountOrderItem;

            /**
             * 订单项折扣后金额
             */
            @JsonProperty("BillingAmountAFDiscountOrderItem")

            private String billingAmountAfDiscountOrderItem;

        }

    }

}
