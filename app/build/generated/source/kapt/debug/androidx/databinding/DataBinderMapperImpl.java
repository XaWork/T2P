package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new me.taste2plate.app.customer.DataBinderMapperImpl());
  }
}
