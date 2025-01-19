package iitpkd.erp.ERPBackend.Utility

class StudentUtil {
    class ElectiveRange (
        var max: Number,
        var min: Number,
        var code: String,
    )

    class CreditRange (
        var min: Number,
        var max: Number,
    )

    class PreRequisiteWaiver(
        var code: String,
        var status: String
    )
}