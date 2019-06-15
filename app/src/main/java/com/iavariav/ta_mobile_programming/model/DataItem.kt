package com.iavariav.ta_mobile_programming.model

import com.google.gson.annotations.SerializedName

data class DataItem(
    val kode_jadwal: String,
    val kode_kelas: String,
    val kode_mk: String,
    val nama_dosen: String,
    val kode_dosen1: String,
    val kode_dosen2: String,
    val sks1: String,
    val nama_ruang: String,
    val hari: String,
    val waktu: String,
    val nama_mk: String,
    val nama_mki: String,
    val error: String,


    @field:SerializedName("rt")
    val rt: String,

    @field:SerializedName("telp")
    val telp: String,

    @field:SerializedName("rw")
    val rw: String,

    @field:SerializedName("agama")
    val agama: String,

    @field:SerializedName("kec")
    val kec: String,

    @field:SerializedName("tahun_masuk")
    val tahunMasuk: String,

    @field:SerializedName("nmortu")
    val nmortu: String,

    @field:SerializedName("kelamin")
    val kelamin: String,

    @field:SerializedName("nik")
    val nik: String,

    @field:SerializedName("darah")
    val darah: String,

    @field:SerializedName("dosen_wali")
    val dosenWali: String,

    @field:SerializedName("kelas")
    val kelas: String,

    @field:SerializedName("prop")
    val prop: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("dusun")
    val dusun: String,

    @field:SerializedName("nisn")
    val nisn: String,

    @field:SerializedName("npm")
    val npm: String,

    @field:SerializedName("tgl_msk")
    val tglMsk: String,

    @field:SerializedName("kalmt")
    val kalmt: String,

    @field:SerializedName("ayah")
    val ayah: String,

    @field:SerializedName("transpor")
    val transpor: String,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("tlhr")
    val tlhr: String,

    @field:SerializedName("foto")
    val foto: String,

    @field:SerializedName("ktlhr")
    val ktlhr: String,

    @field:SerializedName("kpos")
    val kpos: String,

    @field:SerializedName("alamat_kos")
    val alamatKos: String,

    @field:SerializedName("ibu")
    val ibu: String,

    @field:SerializedName("almt")
    val almt: String
)