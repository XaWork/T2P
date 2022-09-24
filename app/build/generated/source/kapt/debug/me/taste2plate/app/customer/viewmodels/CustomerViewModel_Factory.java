// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import me.taste2plate.app.customer.repo.CustomRepository;
import me.taste2plate.app.customer.repo.CustomerRepository;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CustomerViewModel_Factory implements Factory<CustomerViewModel> {
  private final Provider<CustomerRepository> customerRepositoryProvider;

  private final Provider<CustomRepository> customRepositoryProvider;

  public CustomerViewModel_Factory(Provider<CustomerRepository> customerRepositoryProvider,
      Provider<CustomRepository> customRepositoryProvider) {
    this.customerRepositoryProvider = customerRepositoryProvider;
    this.customRepositoryProvider = customRepositoryProvider;
  }

  @Override
  public CustomerViewModel get() {
    return newInstance(customerRepositoryProvider.get(), customRepositoryProvider.get());
  }

  public static CustomerViewModel_Factory create(
      Provider<CustomerRepository> customerRepositoryProvider,
      Provider<CustomRepository> customRepositoryProvider) {
    return new CustomerViewModel_Factory(customerRepositoryProvider, customRepositoryProvider);
  }

  public static CustomerViewModel newInstance(CustomerRepository customerRepository,
      CustomRepository customRepository) {
    return new CustomerViewModel(customerRepository, customRepository);
  }
}
