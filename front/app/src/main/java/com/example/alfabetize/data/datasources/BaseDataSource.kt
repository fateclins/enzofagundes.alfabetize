package com.example.alfabetize.data.datasources

interface BaseDataSource {
    public fun index();
    public fun show();
    public fun create();
    public fun update();
    public fun delete();
}